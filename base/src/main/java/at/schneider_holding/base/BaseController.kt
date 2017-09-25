package at.schneider_holding.base

import com.bluelinelabs.conductor.Controller

abstract class BaseController : Controller() {

  var navigator: BaseNavigator? = null

  abstract fun canGoBack(): Boolean


}
