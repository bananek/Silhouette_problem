

package daos

import javax.inject.Inject

import models.{ Parcels, ParcelsREST }
import play.api.db.slick.{ DatabaseConfigProvider, HasDatabaseConfigProvider }
import slick.driver.JdbcProfile
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ ExecutionContext, Future }

class ParcelsDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import driver.api._

  val Parcels = TableQuery[ParcelsTable]

  def all(implicit ec: ExecutionContext): Future[List[ParcelsREST]] = {
    val query = Parcels
    val results = query.result
    val futureParcels = db.run(results)
    futureParcels.map(
      _.map {
      a => ParcelsREST(oid = a.oid, productlist = a.productlist, shipment = a.shipment, payment = a.payment, price = a.price, uid = a.uid, address = a.address)
    }.toList)
  }

  def insert(parcel: Parcels): Future[Unit] = db.run(Parcels += parcel).map { _ => () }

  def remove(oid: Int): Future[Unit] = db.run(Parcels.filter(_.oid === oid).delete).map { _ => () }

  class ParcelsTable(tag: Tag) extends Table[Parcels](tag, "Parcels") {

    def oid = column[Int]("OID", O.AutoInc, O.AutoInc)

    def productlist = column[String]("PRODUCTLIST")

    def shipment = column[String]("SHIPMENT")

    def payment = column[String]("PAYMENT")

    def price = column[Int]("PRICE")

    def uid = column[String]("UID")

    def address = column[String]("ADDRESS")

    def * = (oid, productlist, shipment, payment, price, uid, address) <> (models.Parcels.tupled, models.Parcels.unapply _)
  }

}
