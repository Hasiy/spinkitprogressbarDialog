package top.hasiy.spinkitProgressBarDemo

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import top.hasiy.spinkitprogressbar.dialog.SpinkitProgressBarDialog
import top.hasiy.spinkitprogressbar.dialog.SpinkitProgressBarDialogConfig
import top.hasiy.spinkitprogressbar.dialog.SpinkitProgressBarDialogManager

/**
 * @Author: Hasiy
 * @Date: 2019/6/13 - 14 : 03
 * @LastEditors: Hasiy
 * @LastEditTime: 2019/6/13 - 14 : 03
 * @Description: BaseActivity
 * @Email: Hasiy.jj@Gmail.com
 */
@SuppressLint("Registered")
abstract class BaseActivity : AppCompatActivity(), SpinkitProgressBarDialogManager {
    override var loadingIsShow: Boolean = false
    override lateinit var spinkitProgressBarDialog: SpinkitProgressBarDialog

    override fun onStart() {
        SpinkitProgressBarDialogConfig.instance.messageShow(true).spinKitColor(Color.parseColor("#a1c4fd"))
            .spinKitStatus("WanderingCubes")
            .apply()
        super.onStart()
    }

    fun dismissBaseProgressBar() {
        if (!this.isDestroyed && !this.isFinishing) {
            dismissSpinkitProgressBarDialog()
        }
    }

    fun showProgressBar() {
        showSpinkitProgressBarDialog(supportFragmentManager)
    }

    fun showBaseProgressBar() {
        SpinkitProgressBarDialogConfig.instance.messageShow(true).spinKitColor(Color.parseColor("#a1c4fd"))
            .spinKitStatus("WanderingCubes")
            .apply()
        spinkitProgressBarDialog = SpinkitProgressBarDialog.instance("正在加载中...")
        showProgressBar()
    }

    fun showBaseProgressBar(text: String) {
        SpinkitProgressBarDialogConfig.instance.messageShow(true).spinKitColor(Color.parseColor("#438BF9"))
            .spinKitStatus("Circle")
            .apply()
        spinkitProgressBarDialog = SpinkitProgressBarDialog.instance(text)
        showProgressBar()
    }


}