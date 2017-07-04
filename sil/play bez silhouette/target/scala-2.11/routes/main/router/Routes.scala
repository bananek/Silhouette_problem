
// @GENERATOR:play-routes-compiler
// @SOURCE:N:/ebiznes/PARCEL/ec/play/conf/routes
// @DATE:Tue Jul 04 21:44:57 CEST 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

object Routes extends Routes

class Routes extends GeneratedRouter {

  import ReverseRouteContext.empty

  override val errorHandler: play.api.http.HttpErrorHandler = play.api.http.LazyHttpErrorHandler

  private var _prefix = "/"

  def withPrefix(prefix: String): Routes = {
    _prefix = prefix
    router.RoutesPrefix.setPrefix(prefix)
    
    this
  }

  def prefix: String = _prefix

  lazy val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation: Seq[(String, String, String)] = List(
    ("""GET""", prefix, """@controllers.Application@.index"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """browse""", """@controllers.Application@.browse"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product""", """@controllers.Application@.product(id:Int ?= 0)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """showusers""", """@controllers.Application@.showusers"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """categories""", """@controllers.Application@.categories"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """category""", """@controllers.Application@.category(id:Int ?= 0)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getcategory""", """@controllers.Application@.getcat(id:Int ?= 0)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cart""", """@controllers.Application@.cart"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """showorders""", """@controllers.Application@.showorders"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pbrowse""", """@controllers.Application@.pbrowse"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """newparcel""", """@controllers.Application@.newparcel"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """newproduct""", """@controllers.Application@.newproduct"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sendorder""", """@controllers.Application@.sendorder"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addtocart""", """@controllers.Application@.addtocart"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """newcategory""", """@controllers.Application@.newcategory"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """removefromcart/$title<[^/]+>""", """@controllers.Application@.removefromcart(title:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """removeproduct/$pid<[^/]+>""", """@controllers.Application@.removeproduct(pid:Int)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """removecategory/$gid<[^/]+>""", """@controllers.Application@.removecategory(gid:Int)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """removeorder/$oid<[^/]+>""", """@controllers.Application@.removeorder(oid:Int)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """removeparcel/$oid<[^/]+>""", """@controllers.Application@.removeparcel(oid:Int)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """showtest""", """@controllers.Application@.showtest"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """removetest""", """@controllers.Application@.removetest(t:Int ?= 0)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """newtest""", """@controllers.Application@.newtest"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Application_browse1_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("browse")))
  )
  private[this] lazy val controllers_Application_browse1_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).browse,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "browse",
      Nil,
      "GET",
      """""",
      this.prefix + """browse"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Application_product2_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product")))
  )
  private[this] lazy val controllers_Application_product2_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).product(fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "product",
      Seq(classOf[Int]),
      "GET",
      """""",
      this.prefix + """product"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Application_showusers3_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("showusers")))
  )
  private[this] lazy val controllers_Application_showusers3_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).showusers,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "showusers",
      Nil,
      "GET",
      """""",
      this.prefix + """showusers"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_categories4_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private[this] lazy val controllers_Application_categories4_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).categories,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "categories",
      Nil,
      "GET",
      """""",
      this.prefix + """categories"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Application_category5_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("category")))
  )
  private[this] lazy val controllers_Application_category5_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).category(fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "category",
      Seq(classOf[Int]),
      "GET",
      """""",
      this.prefix + """category"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Application_getcat6_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getcategory")))
  )
  private[this] lazy val controllers_Application_getcat6_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).getcat(fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getcat",
      Seq(classOf[Int]),
      "GET",
      """""",
      this.prefix + """getcategory"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Application_cart7_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cart")))
  )
  private[this] lazy val controllers_Application_cart7_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).cart,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "cart",
      Nil,
      "GET",
      """""",
      this.prefix + """cart"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Application_showorders8_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("showorders")))
  )
  private[this] lazy val controllers_Application_showorders8_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).showorders,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "showorders",
      Nil,
      "GET",
      """GET     /createproduct              @controllers.Application.createproduct""",
      this.prefix + """showorders"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Application_pbrowse9_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pbrowse")))
  )
  private[this] lazy val controllers_Application_pbrowse9_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).pbrowse,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "pbrowse",
      Nil,
      "GET",
      """""",
      this.prefix + """pbrowse"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Application_newparcel10_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("newparcel")))
  )
  private[this] lazy val controllers_Application_newparcel10_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).newparcel,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "newparcel",
      Nil,
      "POST",
      """""",
      this.prefix + """newparcel"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_Application_newproduct11_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("newproduct")))
  )
  private[this] lazy val controllers_Application_newproduct11_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).newproduct,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "newproduct",
      Nil,
      "POST",
      """""",
      this.prefix + """newproduct"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_Application_sendorder12_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendorder")))
  )
  private[this] lazy val controllers_Application_sendorder12_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).sendorder,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "sendorder",
      Nil,
      "POST",
      """""",
      this.prefix + """sendorder"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_Application_addtocart13_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addtocart")))
  )
  private[this] lazy val controllers_Application_addtocart13_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).addtocart,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "addtocart",
      Nil,
      "POST",
      """""",
      this.prefix + """addtocart"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_Application_newcategory14_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("newcategory")))
  )
  private[this] lazy val controllers_Application_newcategory14_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).newcategory,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "newcategory",
      Nil,
      "POST",
      """""",
      this.prefix + """newcategory"""
    )
  )

  // @LINE:30
  private[this] lazy val controllers_Application_removefromcart15_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("removefromcart/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_removefromcart15_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).removefromcart(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "removefromcart",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """removefromcart/$title<[^/]+>"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_Application_removeproduct16_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("removeproduct/"), DynamicPart("pid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_removeproduct16_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).removeproduct(fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "removeproduct",
      Seq(classOf[Int]),
      "GET",
      """""",
      this.prefix + """removeproduct/$pid<[^/]+>"""
    )
  )

  // @LINE:32
  private[this] lazy val controllers_Application_removecategory17_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("removecategory/"), DynamicPart("gid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_removecategory17_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).removecategory(fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "removecategory",
      Seq(classOf[Int]),
      "GET",
      """""",
      this.prefix + """removecategory/$gid<[^/]+>"""
    )
  )

  // @LINE:33
  private[this] lazy val controllers_Application_removeorder18_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("removeorder/"), DynamicPart("oid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_removeorder18_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).removeorder(fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "removeorder",
      Seq(classOf[Int]),
      "GET",
      """""",
      this.prefix + """removeorder/$oid<[^/]+>"""
    )
  )

  // @LINE:35
  private[this] lazy val controllers_Application_removeparcel19_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("removeparcel/"), DynamicPart("oid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_removeparcel19_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).removeparcel(fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "removeparcel",
      Seq(classOf[Int]),
      "GET",
      """""",
      this.prefix + """removeparcel/$oid<[^/]+>"""
    )
  )

  // @LINE:38
  private[this] lazy val controllers_Application_showtest20_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("showtest")))
  )
  private[this] lazy val controllers_Application_showtest20_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).showtest,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "showtest",
      Nil,
      "GET",
      """""",
      this.prefix + """showtest"""
    )
  )

  // @LINE:39
  private[this] lazy val controllers_Application_removetest21_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("removetest")))
  )
  private[this] lazy val controllers_Application_removetest21_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).removetest(fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "removetest",
      Seq(classOf[Int]),
      "POST",
      """""",
      this.prefix + """removetest"""
    )
  )

  // @LINE:40
  private[this] lazy val controllers_Application_newtest22_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("newtest")))
  )
  private[this] lazy val controllers_Application_newtest22_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).newtest,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "newtest",
      Nil,
      "POST",
      """""",
      this.prefix + """newtest"""
    )
  )

  // @LINE:44
  private[this] lazy val controllers_Assets_at23_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at23_invoker = createInvoker(
    controllers.Assets.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).index)
      }
  
    // @LINE:7
    case controllers_Application_browse1_route(params) =>
      call { 
        controllers_Application_browse1_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).browse)
      }
  
    // @LINE:8
    case controllers_Application_product2_route(params) =>
      call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        controllers_Application_product2_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).product(id))
      }
  
    // @LINE:9
    case controllers_Application_showusers3_route(params) =>
      call { 
        controllers_Application_showusers3_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).showusers)
      }
  
    // @LINE:10
    case controllers_Application_categories4_route(params) =>
      call { 
        controllers_Application_categories4_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).categories)
      }
  
    // @LINE:11
    case controllers_Application_category5_route(params) =>
      call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        controllers_Application_category5_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).category(id))
      }
  
    // @LINE:12
    case controllers_Application_getcat6_route(params) =>
      call(params.fromQuery[Int]("id", Some(0))) { (id) =>
        controllers_Application_getcat6_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).getcat(id))
      }
  
    // @LINE:13
    case controllers_Application_cart7_route(params) =>
      call { 
        controllers_Application_cart7_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).cart)
      }
  
    // @LINE:15
    case controllers_Application_showorders8_route(params) =>
      call { 
        controllers_Application_showorders8_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).showorders)
      }
  
    // @LINE:18
    case controllers_Application_pbrowse9_route(params) =>
      call { 
        controllers_Application_pbrowse9_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).pbrowse)
      }
  
    // @LINE:20
    case controllers_Application_newparcel10_route(params) =>
      call { 
        controllers_Application_newparcel10_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).newparcel)
      }
  
    // @LINE:23
    case controllers_Application_newproduct11_route(params) =>
      call { 
        controllers_Application_newproduct11_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).newproduct)
      }
  
    // @LINE:24
    case controllers_Application_sendorder12_route(params) =>
      call { 
        controllers_Application_sendorder12_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).sendorder)
      }
  
    // @LINE:25
    case controllers_Application_addtocart13_route(params) =>
      call { 
        controllers_Application_addtocart13_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).addtocart)
      }
  
    // @LINE:26
    case controllers_Application_newcategory14_route(params) =>
      call { 
        controllers_Application_newcategory14_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).newcategory)
      }
  
    // @LINE:30
    case controllers_Application_removefromcart15_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_Application_removefromcart15_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).removefromcart(title))
      }
  
    // @LINE:31
    case controllers_Application_removeproduct16_route(params) =>
      call(params.fromPath[Int]("pid", None)) { (pid) =>
        controllers_Application_removeproduct16_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).removeproduct(pid))
      }
  
    // @LINE:32
    case controllers_Application_removecategory17_route(params) =>
      call(params.fromPath[Int]("gid", None)) { (gid) =>
        controllers_Application_removecategory17_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).removecategory(gid))
      }
  
    // @LINE:33
    case controllers_Application_removeorder18_route(params) =>
      call(params.fromPath[Int]("oid", None)) { (oid) =>
        controllers_Application_removeorder18_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).removeorder(oid))
      }
  
    // @LINE:35
    case controllers_Application_removeparcel19_route(params) =>
      call(params.fromPath[Int]("oid", None)) { (oid) =>
        controllers_Application_removeparcel19_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).removeparcel(oid))
      }
  
    // @LINE:38
    case controllers_Application_showtest20_route(params) =>
      call { 
        controllers_Application_showtest20_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).showtest)
      }
  
    // @LINE:39
    case controllers_Application_removetest21_route(params) =>
      call(params.fromQuery[Int]("t", Some(0))) { (t) =>
        controllers_Application_removetest21_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).removetest(t))
      }
  
    // @LINE:40
    case controllers_Application_newtest22_route(params) =>
      call { 
        controllers_Application_newtest22_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).newtest)
      }
  
    // @LINE:44
    case controllers_Assets_at23_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at23_invoker.call(controllers.Assets.at(path, file))
      }
  }
}