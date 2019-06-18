package top.hasiy.spinkitprogressbar.dialog

import android.graphics.Color
import androidx.annotation.CheckResult

/**
 * @Author: Hasiy
 * @Date: 2019/6/13 - 17 : 37
 * @LastEditors: Hasiy
 * @LastEditTime: 2019/6/13 - 17 : 37
 * @Description: Toasts
 * @Email: Hasiy.jj@Gmail.com
 */
class SpinkitProgressBarDialogConfig private constructor() {
    private var messageShow = SpinkitProgressBarDialog.messageShow
    private var spinKitColor = SpinkitProgressBarDialog.spinKitColor
    private var spinKitStatus = SpinkitProgressBarDialog.spinKitStatus

    @CheckResult
    fun messageShow(messageShow: Boolean): SpinkitProgressBarDialogConfig {
        this.messageShow = messageShow
        return this
    }

    @CheckResult
    fun spinKitColor(spinKitColor: Int): SpinkitProgressBarDialogConfig {
        this.spinKitColor = spinKitColor
        return this
    }

    @CheckResult
    fun spinKitStatus(spinKitStatus: String): SpinkitProgressBarDialogConfig {
        this.spinKitStatus = spinKitStatus
        return this
    }

    fun apply() {
        SpinkitProgressBarDialog.messageShow = messageShow
        SpinkitProgressBarDialog.spinKitColor = spinKitColor
        SpinkitProgressBarDialog.spinKitStatus = spinKitStatus
    }

    companion object {
        val instance: SpinkitProgressBarDialogConfig
            @CheckResult
            get() = SpinkitProgressBarDialogConfig()

        fun reset() {
            SpinkitProgressBarDialog.messageShow = false
            SpinkitProgressBarDialog.spinKitColor = Color.parseColor("#438BF9")
            SpinkitProgressBarDialog.spinKitStatus = "FoldingCube"
        }
    }
}
