package controllers

import javax.inject.Inject

import daos._
import models._
import play.api.libs.json.Json
import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.data.Forms.text
import play.api.data.Forms.number
import play.api.mvc._
import javax.inject.Inject

import play.api.libs.concurrent.Execution.Implicits.defaultContext

class Application @Inject() (parcelsDAO: ParcelsDAO, productsDAO: ProductsDAO, orderDAO: OrderDAO, categoriesDAO: CategoriesDAO, cartDAO: CartDAO, userDAO: UserDAO, testDAO: TestDAO) extends Controller {


  val productForm = Form(
    mapping(
      "title" -> text(),
      "author" -> text(),
      "description" -> text(),
      "pid" -> number(0),
      "gid" -> number,
      "price" -> number
    )(Products.apply)(Products.unapply)
  )

  val parcelForm = Form(
    mapping(
      "oid" -> number(0),
      "productlist" -> text(),
      "shipment" -> text(),
      "payment" -> text(),
      "price" -> number,
      "uid" -> text(),
      "address" -> text()
    )(Parcels.apply)(Parcels.unapply)
  )

  val categoryForm = Form(
    mapping(
      "gid" -> number,
      "genre" -> text()
    )(Categories.apply)(Categories.unapply)
  )

  val orderForm = Form(
    mapping(
        "oid" -> number(0),
        "productlist" -> text(),
        "shipment" -> text(),
        "payment" -> text(),
        "price" -> number,
        "uid" -> text(),
        "address" -> text()
    )(Order.apply)(Order.unapply)
  )

  val testForm = Form(
    mapping(
      "t" -> number
    )(Test.apply)(Test.unapply)
  )
/*
  def addtocart = Action { implicit request =>
    val product: Cart = productForm.bindFromRequest().get
    cartDAO.insert(product)
  }
  */
  // list of all products
  def index = Action{
    Ok
  }

/*
  def createproduct = Action {
    Ok(views.html.createproduct.render())
  }*/


  def browse = Action.async { implicit  request =>
    productsDAO.all map {
      products => Ok(Json.toJson(products))
    }
  }

  def pbrowse = Action.async { implicit  request =>
    parcelsDAO.all map {
      parcels => Ok(Json.toJson(parcels))
    }
  }


  def showorders = Action.async { implicit  request =>
    orderDAO.all map {
      orders => Ok(Json.toJson(orders))
    }
  }

  def showtest = Action.async { implicit  request =>
    testDAO.all map {
      tests => Ok(Json.toJson(tests))
    }
  }

  def removetest(t: Int) = Action { implicit request =>
    testDAO.remove(t)
    Ok("200")
  }

  def newtest = Action { implicit request =>
    val test: models.Test = testForm.bindFromRequest().get
    testDAO.insert(test)
    Ok
  }

  def cart = Action.async { implicit  request =>
    cartDAO.all map {
      products => Ok(Json.toJson(products))
    }
  }

  // ORDERS
/*
  def sendorder = Action { implicit request =>
    var json:OrderREST = request.body.asJson.get.as[OrderREST]
    var order = Order(oid = json.oid,  productlist = json.productlist, shipment = json.shipment, payment = json.payment,  price = json.price, uid = json.uid, address = json.address)
    orderDAO.insert(order)
    Ok(request.body.asJson.get)
  }*/

  def sendorder = Action { implicit request =>
    val order: models.Order = orderForm.bindFromRequest().get
    orderDAO.insert(order)
    Ok
  }


  def newproduct = Action { implicit request =>
    val product: models.Products = productForm.bindFromRequest().get
    productsDAO.insert(product)
    Ok
  }

  def newparcel = Action { implicit request =>
    val parcel: models.Parcels = parcelForm.bindFromRequest().get
    parcelsDAO.insert(parcel)
    Ok
  }


  // CART

  def removefromcart(title: String) = Action { implicit request =>
    cartDAO.remove(title)
    Ok("200")
  }

  def removeproduct(pid: Int) = Action { implicit request =>
    productsDAO.remove(pid)
    Ok
  }

  def removecategory(gid: Int) = Action { implicit request =>
    categoriesDAO.remove(gid)
    Ok
  }

  def removeparcel(oid: Int) = Action { implicit request =>
    parcelsDAO.remove(oid)
    Ok
  }
  def removeorder(oid: Int) = Action { implicit request =>
    orderDAO.remove(oid)
    Ok
  }


  def addtocart = Action { implicit request =>
    var json:CartREST = request.body.asJson.get.as[CartREST]
    var cart = Cart(title = json.title, price = json.price,  uid = json.uid)
    cartDAO.insert(cart)
    Ok
  }

  def showusers = Action.async { implicit  request =>
    userDAO.all map {
      users => Ok(Json.toJson(users))
    }
  }




  // list of categories
  def categories = Action.async { implicit  request =>
    categoriesDAO.all map {
      categories => Ok(Json.toJson(categories))
    }
  }

  // data connected with one specific product
  def product(id: Int) = Action.async { implicit  request =>
    productsDAO.one(id) map {
      products => Ok(Json.toJson(products))
    }
  }

  def getcat(id: Int) = Action.async { implicit  request =>
    categoriesDAO.one(id) map {
      categories => Ok(Json.toJson(categories))
    }
  }

  // list of all products from a specified category
  def category(id: Int) = Action.async { implicit  request =>
    productsDAO.fromCategory(id) map {
      products => Ok(Json.toJson(products))
    }
  }

  def newcategory = Action { implicit request =>
    val category: models.Categories = categoryForm.bindFromRequest().get
    categoriesDAO.insert(category)
    Ok
  }

  /*
  def newuser = Action{ implicit request =>
    val user: models.User = userForm.bindFromRequest().get
    userDAO.insert(user)
    Ok(views.html.newuser.render(user))
  }

  def deleteproduct(title:String) = Action { implicit request =>
    productDAO.delete(title)
    Redirect(routes.Application.index())
  }

  def applyproductchanges = Action { implicit request =>
    val updatedProduct: models.Product = productForm.bindFromRequest().get
    productDAO.update(updatedProduct.title,updatedProduct)
    Redirect(routes.Application.index())
  }




  */

}
