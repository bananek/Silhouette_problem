package daos

/**
 * Created by BanaN on 6/19/2017.
 */

import javax.inject.Inject

import models.{ Cart, CartREST }
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ ExecutionContext, Future }

import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.driver.JdbcProfile

class CartDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import driver.api._

  val Mercs = TableQuery[CartTable]

  def all(implicit ec: ExecutionContext): Future[List[CartREST]] = {
    val query = Mercs
    val results = query.result
    val futureProducts = db.run(results)
    futureProducts.map(
      _.map {
      a => CartREST(title = a.title, price = a.price, uid = a.uid)
    }.toList)
  }

  def remove(title: String): Future[Unit] = db.run(Mercs.filter(_.title === title).delete).map { _ => () }

  def insert(cart: Cart): Future[Unit] = db.run(Mercs += cart).map { _ => () }

  class CartTable(tag: Tag) extends Table[Cart](tag, "CART") {

    def title = column[String]("TITLE", O.PrimaryKey)

    def price = column[Int]("PRICE")

    def uid = column[String]("UID")

    def * = (title, price, uid) <> (models.Cart.tupled, models.Cart.unapply _)
  }

}