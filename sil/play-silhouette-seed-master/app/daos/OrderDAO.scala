

package daos

import javax.inject.Inject

import models.{ Order, OrderREST }
import play.api.db.slick.{ DatabaseConfigProvider, HasDatabaseConfigProvider }
import slick.driver.JdbcProfile
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ ExecutionContext, Future }

class OrderDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import driver.api._

  val Orders = TableQuery[OrderTable]

  def all(implicit ec: ExecutionContext): Future[List[OrderREST]] = {
    val query = Orders
    val results = query.result
    val futureOrders = db.run(results)
    futureOrders.map(
      _.map {
      a => OrderREST(oid = a.oid, productlist = a.productlist, shipment = a.shipment, payment = a.payment, price = a.price, uid = a.uid, address = a.address)
    }.toList)
  }

  def insert(order: Order): Future[Unit] = db.run(Orders += order).map { _ => () }

  def remove(oid: Int): Future[Unit] = db.run(Orders.filter(_.oid === oid).delete).map { _ => () }

  class OrderTable(tag: Tag) extends Table[Order](tag, "Order") {

    def oid = column[Int]("OID", O.AutoInc, O.AutoInc)

    def productlist = column[String]("PRODUCTLIST")

    def shipment = column[String]("SHIPMENT")

    def payment = column[String]("PAYMENT")

    def price = column[Int]("PRICE")

    def uid = column[String]("UID")

    def address = column[String]("ADDRESS")

    def * = (oid, productlist, shipment, payment, price, uid, address) <> (models.Order.tupled, models.Order.unapply _)
  }

}
