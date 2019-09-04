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
        dialog13.setOnClickListener {
            show("Heartbeat")
        }
    }

    private fun show(text: String) {
        val timer = Timer()
        SpinkitProgressBarDialogConfig.instance.messageShow(true).spinKitColor(Color.parseColor("#a3bded"))
            .spinKitStatus(text).apply()

        Log.e("Hasiy", "SpinkitProgressBar0")
        showBaseProgressBar("SpinkitProgressBar0")
        dismissBaseProgressBar()
        Log.e("Hasiy", "SpinkitProgressBar1")
        showBaseProgressBar("SpinkitProgressBar1")
        dismissBaseProgressBar()
        Log.e("Hasiy", "SpinkitProgressBar2")
        showBaseProgressBar("SpinkitProgressBar2")
        dismissBaseProgressBar()
        Log.e("Hasiy", "SpinkitProgressBar3")
        showBaseProgressBar("SpinkitProgressBar3")
        dismissBaseProgressBar()

//        showBaseProgressBar("Loading...")
//
//        timer.schedule(object : TimerTask() {
//            override fun run() {
//                dismissBaseProgressBar()
//            }
//        }, 5000)
    }

}
