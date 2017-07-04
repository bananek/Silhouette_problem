package models

import play.api.libs.json.Json

/**
  * Created by kprzystalski on 23/04/17.
  */


case class ProductsREST(title: String, author: String, description: String, pid: Int, gid: Int, price: Int)
case class CategoriesREST(gid: Int, genre: String)
case class UserREST(name: String, email: String, password: String, priv: Int)
case class OrderREST(oid: Int,  productlist: String, shipment: String, payment: String,  price: Int, uid: String, address: String)
case class CartREST(title: String, price: Int, uid: String)
case class TestREST(t: Int)
case class ParcelsREST(oid: Int,  productlist: String, shipment: String, payment: String,  price: Int, uid: String, address: String)

object ProductsREST {
  implicit val productsFormat = Json.format[ProductsREST]
}

object CategoriesREST {
  implicit val categoriesFormat = Json.format[CategoriesREST]
}

object UserREST{
  implicit val userFormat = Json.format[UserREST]
}

object OrderREST{
  implicit val orderFormat = Json.format[OrderREST]
}

object CartREST{
  implicit val cartFormat = Json.format[CartREST]
}

object TestREST{
  implicit var testFormat = Json.format[TestREST]
}

object ParcelsREST{
  implicit var parcelsFormat = Json.format[ParcelsREST]
}