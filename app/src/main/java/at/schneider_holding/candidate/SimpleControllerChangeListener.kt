package at.schneider_holding.candidate

import android.view.ViewGroup
import at.schneider_holding.base.BaseController
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler

abstract class SimpleControllerChangeListener : ControllerChangeHandler.ControllerChangeListener {
  override fun onChangeStarted(to: Controller?, from: Controller?, isPush: Boolean, container: ViewGroup, handler: ControllerChangeHandler) {}

  override fun onChangeCompleted(to: Controller?, from: Controller?, isPush: Boolean, container: ViewGroup, handler: ControllerChangeHandler) {
    onChangeCompleted(to as BaseController?, from as BaseController?)
  }

  abstract fun onChangeCompleted(to: BaseController?, from: BaseController?)
}
