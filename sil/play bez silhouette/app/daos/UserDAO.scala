package daos

/**
  * Created by BanaN on 6/19/2017.
  */

import javax.inject.Inject

import models.{User, UserREST}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.driver.JdbcProfile
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}

class UserDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import driver.api._

  private val Users = TableQuery[UserTable]

  def all(implicit ec: ExecutionContext): Future[List[UserREST]] = {
    val query =  Users
    val results = query.result
    val futureProducts = db.run(results)
    futureProducts.map(
      _.map {
        a => UserREST(name = a.name, email = a.email, password = a.password, priv = a.priv)
      }.toList)
  }

  private class UserTable(tag: Tag) extends Table[User](tag, "USERS") {

    def name = column[String]("NAME", O.PrimaryKey)

    def email = column[String]("EMAIL")

    def password = column[String]("PASSWORD")

    def priv = column[Int]("PRIV")

    def * = (name, email, password, priv) <>(models.User.tupled, models.User.unapply _)
  }

}