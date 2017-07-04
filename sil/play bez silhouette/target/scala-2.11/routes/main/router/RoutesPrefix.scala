
// @GENERATOR:play-routes-compiler
// @SOURCE:N:/ebiznes/PARCEL/ec/play/conf/routes
// @DATE:Tue Jul 04 21:44:57 CEST 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
