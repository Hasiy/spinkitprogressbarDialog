package top.hasiy.spinkitProgressBarDemo

import android.graphics.Color
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import com.hasiy.toastsDemo.R
import top.hasiy.spinkitprogressbar.dialog.SpinkitProgressBarDialog
import top.hasiy.spinkitprogressbar.dialog.SpinkitProgressBarDialogConfig
import java.util.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialog1.setOnClickListener {
            SpinkitProgressBarDialogConfig.instance.messageShow(true).spinKitColor(Color.parseColor("#a1c4fd")).spinKitStatus("WanderingCubes")
                .apply()
            spinkitProgressBarDialog = SpinkitProgressBarDialog.newInstance("正在加载中...")

            showBaseProgressBar()
            dismissBaseProgressBar()

            val timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    showBaseProgressBar("123123")
                    dismissBaseProgressBar()
                }
            }, 800)
        }
    }

}
