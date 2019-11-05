package top.hasiy.spinkitprogressbar.dialog

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import top.hasiy.spinkit.SpinKitView
import top.hasiy.spinkit.sprite.Sprite
import top.hasiy.spinkit.style.*
import android.util.Log
import android.view.*
import kotlinx.android.synthetic.main.spinkit_progressbar_dialog_layout.*
import top.hasiy.spinkit.BuildConfig
import top.hasiy.spinkitprogressbar.R
import java.util.*

/**
 * @Author: Hasiy
 * @Date: 2019/6/13 - 10 : 12
 * @LastEditors: Hasiy
 * @LastEditTime: 2019/11/1 - 10 : 12
 * @Description: SpinkitProgressBarDialog
 * @Email: Hasiy.jj@Gmail.com
 */

class SpinkitProgressBarDialog : BaseDialog() {
    override fun getViewId(): Int {
        return R.layout.spinkit_progressbar_dialog_layout
    }

    override fun initUI(rootView: View) {
        when (messageShow) {
            true -> {
                loading_message.visibility = View.VISIBLE
                loading_message.text = message
            }
            false -> {
                loading_message.visibility = View.GONE
            }
        }
        spinKit = when (spinKitStatus) {
            "RotatingPlane" -> RotatingPlane()
            "DoubleBounce" -> DoubleBounce()
            "Wave" -> Wave()
            "WanderingCubes" -> WanderingCubes()
            "Pulse" -> Pulse()
            "ChasingDots" -> ChasingDots()
            "ThreeBounce" -> ThreeBounce()
            "Circle" -> Circle()
            "CubeGrid" -> CubeGrid()
            "FadingCircle" -> FadingCircle()
            "FoldingCube" -> FoldingCube()
            "RotatingCircle" -> RotatingCircle()
            "Heartbeat" -> Heartbeat()
            else -> FoldingCube()
        }
        loadingBar.setIndeterminateDrawable(spinKit)
        loadingBar.setColor(spinKitColor)
    }

    private var spinKit: Sprite = FadingCircle()
    private var message by FragmentArgumentDelegate<String>()

    companion object {
        /**
         *  messageShow 是否显示Loading文字
         *  message  Loading文字内容
         *  spinKitStatus  Loading 动画样式
         *  spinKitColor  Loading 动画颜色
         */
        var messageShow: Boolean = false
        var spinKitColor: Int = Color.parseColor("#438BF9") // 默认加载动画颜色为#438BF9
        var spinKitStatus: String = "FoldingCube" // 默认加载动画是 FoldingCube
        fun instance(message: String) = SpinkitProgressBarDialog().apply {
            this.message = message
        }

    }
}
