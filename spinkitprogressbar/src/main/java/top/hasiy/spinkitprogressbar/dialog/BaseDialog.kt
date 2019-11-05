package top.hasiy.spinkitprogressbar.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import top.hasiy.spinkit.BuildConfig
import top.hasiy.spinkitprogressbar.R
import java.util.*

/**
 * @Author: Hasiy
 * @Date: 2019/1/3 - 17 : 37
 * @LastEditors: Hasiy
 * @LastEditTime: 2019/10/13 - 9 : 49
 * @Description: Base
 * @Email: Hasiy.jj@Gmail.com
 */

abstract class BaseDialog : DialogFragment() {
    private var serviceCurrentMills = 0L
    private var loadingCompleted: Boolean = false
    private var dismissCompleted: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
        this.setStyle(STYLE_NO_TITLE, R.style.dialogStyles)
        serviceCurrentMills = System.currentTimeMillis()
        loadingCompleted = true
        dismissCompleted = false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getViewId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI(view)
        initEvent()
    }

    abstract fun getViewId(): Int
    abstract fun initUI(rootView: View)
    open fun initEvent() {}

    override fun onSaveInstanceState(outState: Bundle) {
        loadingCompleted = false
        super.onSaveInstanceState(outState)
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
        if (System.currentTimeMillis() - serviceCurrentMills > 100 && loadingCompleted && !dismissCompleted) {
            try {
                super.dismiss()
                loadingCompleted = false
                dismissCompleted = true
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("Hasiy", "BaseDialog:$e.toString()")
            }
        } else if (!dismissCompleted) {
            val timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    if (BuildConfig.DEBUG) {
                        Log.e("Hasiy", "BaseDialog:dismiss = !dismissCompleted")
                    }
                    dismiss()
                }
            }, 90)
        }
    }

    override fun onStart() {
        super.onStart()
        val window = dialog!!.window
        val params = window!!.attributes
        params.gravity = Gravity.CENTER
        params.width = WindowManager.LayoutParams.WRAP_CONTENT
        params.height = WindowManager.LayoutParams.WRAP_CONTENT
        window.attributes = params
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onDestroy() {
        dismissCompleted = true
        loadingCompleted = false
        super.onDestroy()
    }

}
