
// @GENERATOR:play-routes-compiler
// @SOURCE:N:/ebiznes/PARCEL/ec/play/conf/routes
// @DATE:Tue Jul 04 21:44:57 CEST 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:44
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def at(file:String): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def product(id:Int = 0): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "product" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
    }
  
    // @LINE:13
    def cart(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "cart")
    }
  
    // @LINE:23
    def newproduct(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "newproduct")
    }
  
    // @LINE:20
    def newparcel(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "newparcel")
    }
  
    // @LINE:9
    def showusers(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "showusers")
    }
  
    // @LINE:39
    def removetest(t:Int = 0): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "removetest" + queryString(List(if(t == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("t", t)))))
    }
  
    // @LINE:10
    def categories(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "categories")
    }
  
    // @LINE:25
    def addtocart(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "addtocart")
    }
  
    // @LINE:30
    def removefromcart(title:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "removefromcart/" + implicitly[PathBindable[String]].unbind("title", dynamicString(title)))
    }
  
    // @LINE:7
    def browse(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "browse")
    }
  
    // @LINE:35
    def removeparcel(oid:Int): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "removeparcel/" + implicitly[PathBindable[Int]].unbind("oid", oid))
    }
  
    // @LINE:31
    def removeproduct(pid:Int): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "removeproduct/" + implicitly[PathBindable[Int]].unbind("pid", pid))
    }
  
    // @LINE:18
    def pbrowse(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "pbrowse")
    }
  
    // @LINE:11
    def category(id:Int = 0): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "category" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
    }
  
    // @LINE:15
    def showorders(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "showorders")
    }
  
    // @LINE:40
    def newtest(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "newtest")
    }
  
    // @LINE:24
    def sendorder(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "sendorder")
    }
  
    // @LINE:33
    def removeorder(oid:Int): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "removeorder/" + implicitly[PathBindable[Int]].unbind("oid", oid))
    }
  
    // @LINE:26
    def newcategory(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "newcategory")
    }
  
    // @LINE:12
    def getcat(id:Int = 0): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getcategory" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
    }
  
    // @LINE:38
    def showtest(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "showtest")
    }
  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
    // @LINE:32
    def removecategory(gid:Int): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "removecategory/" + implicitly[PathBindable[Int]].unbind("gid", gid))
    }
  
  }


}