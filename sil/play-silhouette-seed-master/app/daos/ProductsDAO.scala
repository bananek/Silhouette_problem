

package daos

import javax.inject.Inject

import models.{ Products, ProductsREST }
import play.api.db.slick.{ DatabaseConfigProvider, HasDatabaseConfigProvider }
import slick.driver.JdbcProfile
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ ExecutionContext, Future }

class ProductsDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import driver.api._

  val Products = TableQuery[ProductsTable]

  def all(implicit ec: ExecutionContext): Future[List[ProductsREST]] = {
    val query = Products
    val results = query.result
    val futureProducts = db.run(results)
    futureProducts.map(
      _.map {
      a => ProductsREST(title = a.title, author = a.author, description = a.description, pid = a.pid, gid = a.gid, price = a.price)
    }.toList)
  }

  def one(pid: Int): Future[Option[ProductsREST]] = {
    val futureProduct = db.run(Products.filter(_.pid === pid).result.headOption)
    futureProduct.map(
      _.map {
        a => ProductsREST(title = a.title, author = a.author, description = a.description, pid = a.pid, gid = a.gid, price = a.price)
      })
  }

  def fromCategory(gid: Int): Future[List[ProductsREST]] = {
    val futureProduct = db.run(Products.filter(_.gid === gid).result)
    futureProduct.map(
      _.map {
      a => ProductsREST(title = a.title, author = a.author, description = a.description, pid = a.pid, gid = a.gid, price = a.price)
    }.toList)
  }

  def insert(product: Products): Future[Unit] = db.run(Products += product).map { _ => () }

  def remove(pid: Int): Future[Unit] = db.run(Products.filter(_.pid === pid).delete).map { _ => () }

  class ProductsTable(tag: Tag) extends Table[Products](tag, "Products") {

    def title = column[String]("TITLE", O.PrimaryKey)

    def author = column[String]("AUTHOR")

    def description = column[String]("DESCRIPTION")

    def pid = column[Int]("PID")

    def gid = column[Int]("GID")

    def price = column[Int]("PRICE")

    def * = (title, author, description, pid, gid, price) <> (models.Products.tupled, models.Products.unapply _)
  }

}
