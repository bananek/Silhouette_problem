
// @GENERATOR:play-routes-compiler
// @SOURCE:N:/ebiznes/PARCEL/ec/play/conf/routes
// @DATE:Tue Jul 04 21:44:57 CEST 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:44
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def product: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.product",
      """
        function(id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
        }
      """
    )
  
    // @LINE:13
    def cart: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.cart",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cart"})
        }
      """
    )
  
    // @LINE:23
    def newproduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.newproduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "newproduct"})
        }
      """
    )
  
    // @LINE:20
    def newparcel: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.newparcel",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "newparcel"})
        }
      """
    )
  
    // @LINE:9
    def showusers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.showusers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "showusers"})
        }
      """
    )
  
    // @LINE:39
    def removetest: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.removetest",
      """
        function(t) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "removetest" + _qS([(t == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("t", t))])})
        }
      """
    )
  
    // @LINE:10
    def categories: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.categories",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "categories"})
        }
      """
    )
  
    // @LINE:25
    def addtocart: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.addtocart",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addtocart"})
        }
      """
    )
  
    // @LINE:30
    def removefromcart: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.removefromcart",
      """
        function(title) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "removefromcart/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("title", encodeURIComponent(title))})
        }
      """
    )
  
    // @LINE:7
    def browse: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.browse",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "browse"})
        }
      """
    )
  
    // @LINE:35
    def removeparcel: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.removeparcel",
      """
        function(oid) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "removeparcel/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("oid", oid)})
        }
      """
    )
  
    // @LINE:31
    def removeproduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.removeproduct",
      """
        function(pid) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "removeproduct/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("pid", pid)})
        }
      """
    )
  
    // @LINE:18
    def pbrowse: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.pbrowse",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pbrowse"})
        }
      """
    )
  
    // @LINE:11
    def category: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.category",
      """
        function(id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "category" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
        }
      """
    )
  
    // @LINE:15
    def showorders: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.showorders",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "showorders"})
        }
      """
    )
  
    // @LINE:40
    def newtest: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.newtest",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "newtest"})
        }
      """
    )
  
    // @LINE:24
    def sendorder: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.sendorder",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendorder"})
        }
      """
    )
  
    // @LINE:33
    def removeorder: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.removeorder",
      """
        function(oid) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "removeorder/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("oid", oid)})
        }
      """
    )
  
    // @LINE:26
    def newcategory: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.newcategory",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "newcategory"})
        }
      """
    )
  
    // @LINE:12
    def getcat: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getcat",
      """
        function(id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getcategory" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
        }
      """
    )
  
    // @LINE:38
    def showtest: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.showtest",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "showtest"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:32
    def removecategory: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.removecategory",
      """
        function(gid) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "removecategory/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("gid", gid)})
        }
      """
    )
  
  }


}