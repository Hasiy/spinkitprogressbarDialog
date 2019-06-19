package top.hasiy.spinkitprogressbar.dialog

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.github.ybq.android.spinkit.SpinKitView
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.*
import android.util.Log
import android.view.*
import java.util.*

/**
 * @Author: Hasiy
 * @Date: 2019/6/13 - 10 : 12
 * @LastEditors: Hasiy
 * @LastEditTime: 2019/6/13 - 10 : 12
 * @Description: SpinkitProgressBarDialog
 * @Email: Hasiy.jj@Gmail.com
 */

class SpinkitProgressBarDialog : DialogFragment() {

    private var messageShow: Boolean = false
    private lateinit var message: String
    private var spinKitColor: Int = Color.parseColor("#438BF9") // 默认加载动画颜色为#438BF9
    private lateinit var spinKitStatus: String   // 默认加载动画是 FoldingCube 详情 https://github.com/ybq/Android-SpinKit
    private var spinKit: Sprite = FadingCircle()
    private lateinit var loadingMessage: TextView
    private lateinit var loadingBar: SpinKitView
    private var serviceCurrentMills = 0L
    private var loadingCompleted: Boolean = false
    private var dismissCompleted: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
        setStyle(STYLE_NO_TITLE, top.hasiy.spinkitprogressbar.R.style.dialogStyles)
        val bundle = arguments
        this.messageShow = bundle!!.getBoolean("messageShow")
        this.message = bundle.getString("message") ?: "加载中..."
        this.spinKitColor = bundle.getInt("spinKitColor")
        this.spinKitStatus = bundle.getString("spinKitStatus") ?: "FoldingCube"
        serviceCurrentMills = System.currentTimeMillis()
        loadingCompleted = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val rootView: View = inflater.inflate(top.hasiy.spinkitprogressbar.R.layout.spinkit_progressbar_dialog_layout, container, false)
        loadingMessage = rootView.findViewById(top.hasiy.spinkitprogressbar.R.id.loading_message) as TextView
        when (messageShow) {
            true -> {
                loadingMessage.visibility = View.VISIBLE
                loadingMessage.text = message
            }
            false -> loadingMessage.visibility = View.GONE
        }
        loadingBar = rootView.findViewById(top.hasiy.spinkitprogressbar.R.id.loadingBar) as SpinKitView
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
            else -> FoldingCube()
        }
        loadingBar.setIndeterminateDrawable(spinKit)
        loadingBar.setColor(spinKitColor)
        return rootView
    }

    override fun show(manager: FragmentManager, tag: String?) {
        if (!loadingCompleted) {
            dismissCompleted = false
            try {
                val transaction = manager.beginTransaction()
                transaction.add(this, tag)
                transaction.commitAllowingStateLoss()
            } catch (e: IllegalStateException) {
                e.printStackTrace()
            }
        }
    }

    override fun dismiss() {
        // 防止未完成显示就关闭,引发catch
        if (System.currentTimeMillis() - serviceCurrentMills > 500 && loadingCompleted && !dismissCompleted) {
            try {
                super.dismiss()
                dismissCompleted = true
                loadingCompleted = false
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("Hasiy", "SpinkitProgressBarError:$e.toString()")
            }
        } else if (!dismissCompleted) {
            val timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    dismiss()
                }
            }, 300)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        loadingCompleted = false
        super.onSaveInstanceState(outState)
    }


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

        fun instance(message: String): SpinkitProgressBarDialog {
            val fragment = SpinkitProgressBarDialog()
            val bundle = Bundle()
            bundle.putString("message", message)
            bundle.putBoolean("messageShow", messageShow)
            bundle.putString("spinKitStatus", spinKitStatus)
            bundle.putInt("spinKitColor", spinKitColor)
            fragment.arguments = bundle
            return fragment
        }
    }
}


 