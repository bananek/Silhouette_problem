package daos

/**
  * Created by BanaN on 6/19/2017.
  */


/**
  * Created by BanaN on 6/19/2017.
  */

import javax.inject.Inject

import models.{Test, TestREST}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}

import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.driver.JdbcProfile

class TestDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import driver.api._

  val Tests = TableQuery[TestTable]

  def all(implicit ec: ExecutionContext): Future[List[TestREST]] = {
    val query =  Tests
    val results = query.result
    val futureProducts = db.run(results)
    futureProducts.map(
      _.map {
        a => TestREST(t = a.t)
      }.toList)
  }

  def remove(t: Int): Future[Unit] = db.run(Tests.filter(_.t === t).delete).map { _ => () }

  def insert(test: Test): Future[Unit] = db.run(Tests += test).map { _ => () }

  class TestTable(tag: Tag) extends Table[Test](tag, "TEST") {

    def t = column[Int]("t")

    def * = (t) <>(models.Test.apply, models.Test.unapply _)
  }

}