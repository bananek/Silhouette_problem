package daos

import javax.inject.Inject

import models.{Categories, CategoriesREST}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.driver.JdbcProfile
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}


class CategoriesDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import driver.api._

  val Categories = TableQuery[CategoriesTable]

  def all(implicit ec: ExecutionContext): Future[List[CategoriesREST]] = {
    val query =  Categories
    val results = query.result
    val futureCategories = db.run(results)
    futureCategories.map(
      _.map {
        a => CategoriesREST(genre = a.genre, gid = a.gid)
      }.toList)
  }

  def one(gid: Int): Future[Option[CategoriesREST]] = {
    val futureCategory = db.run(Categories.filter(_.gid === gid).result.headOption)
    futureCategory.map(
      _.map {
        a => CategoriesREST(gid = a.gid, genre = a.genre)
      })
  }


  def insert(category: Categories): Future[Unit] = db.run(Categories += category).map { _ => () }

  def remove(gid: Int): Future[Unit] = db.run(Categories.filter(_.gid === gid).delete).map { _ => () }


  class CategoriesTable(tag: Tag) extends Table[Categories](tag, "CATEGORIES") {
    def gid = column[Int]("GID",O.AutoInc, O.AutoInc)
    def genre = column[String]("GENRE")
    def * = (gid, genre) <> (models.Categories.tupled, models.Categories.unapply)
  }

}
