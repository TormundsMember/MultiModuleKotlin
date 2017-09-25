package at.schneider_holding.candidate

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import at.schneider_holding.base.BaseController
import at.schneider_holding.base.BaseNavigator
import at.schneider_holding.chat.ChatController
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction

class MainActivity : AppCompatActivity(), BaseNavigator {


  private lateinit var router: Router
  private var currentController: BaseController? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val container = findViewById(R.id.container) as ConstraintLayout
    router = Conductor.attachRouter(this, container, savedInstanceState)
    router.addChangeListener(object : SimpleControllerChangeListener() {
      override fun onChangeCompleted(to: BaseController?, from: BaseController?) {
        currentController = to
        currentController?.navigator = this@MainActivity
        from?.navigator = null
      }
    })
  }

  override fun onBackPressed() {
    if (currentController?.canGoBack() != false)
      if (!router.handleBack())
        super.onBackPressed()
  }

  override fun goToChat() {
    router.setRoot(RouterTransaction.with(ChatController()))
  }
}
