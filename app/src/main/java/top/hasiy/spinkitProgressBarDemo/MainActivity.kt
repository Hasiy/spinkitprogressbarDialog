package top.hasiy.spinkitProgressBarDemo

import android.graphics.Color
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MenuItem
import com.hasiy.toastsDemo.R
import top.hasiy.spinkitprogressbar.dialog.SpinkitProgressBarDialogConfig
import java.util.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialog1.setOnClickListener {
            show("RotatingPlane")
        }
        dialog2.setOnClickListener {
            show("DoubleBounce")
        }
        dialog3.setOnClickListener {
            show("Wave")
        }
        dialog4.setOnClickListener {
            show("WanderingCubes")
        }
        dialog5.setOnClickListener {
            show("Pulse")
        }
        dialog6.setOnClickListener {
            show("ChasingDots")
        }
        dialog7.setOnClickListener {
            show("ThreeBounce")
        }
        dialog8.setOnClickListener {
            show("Circle")
        }
        dialog9.setOnClickListener {
            show("CubeGrid")
        }
        dialog10.setOnClickListener {
            show("FadingCircle")
        }
        dialog11.setOnClickListener {
            show("FoldingCube")
        }
        dialog12.setOnClickListener {
            show("RotatingCircle")
        }
    }

    private fun show(text: String) {
        val timer = Timer()
        SpinkitProgressBarDialogConfig.instance.messageShow(true).spinKitColor(Color.parseColor("#a1c4fd"))
            .spinKitStatus(text).apply()
        // 设置显示效果
        showBaseProgressBar()
        dismissBaseProgressBar()

        showBaseProgressBar("哈哈哈哈哈")

        timer.schedule(object : TimerTask() {
            override fun run() {
                dismissBaseProgressBar()
            }
        }, 5000)

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP || keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            Log.e("hasiy","::onKeyDown ")
            dismissBaseProgressBar()
            return true
        }else if (keyCode == KeyEvent.KEYCODE_BACK) {
            Log.e("hasiy","::onKeyDown ")
            dismissBaseProgressBar()
            return true
        }
        return false
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home) {
            Log.e("hasiy","::onKeyDown ")
            dismissBaseProgressBar()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
