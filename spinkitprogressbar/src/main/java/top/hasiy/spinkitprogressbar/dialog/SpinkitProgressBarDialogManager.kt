package top.hasiy.spinkitprogressbar.dialog

import android.util.Log
import androidx.fragment.app.FragmentManager
import java.util.*

/**
 * @Author: Hasiy
 * @Date: 2019/6/13 - 13 : 37
 * @LastEditors: Hasiy
 * @LastEditTime: 2019/6/13 - 13 : 37
 * @Description: SpinkitProgressBarDialogManager
 * @Email: Hasiy.jj@Gmail.com
 */
interface SpinkitProgressBarDialogManager {

    val spinkitProgressBarDialog: SpinkitProgressBarDialog
    var loadingIsShow: Boolean

    fun showSpinkitProgressBarDialog(supportFragmentManager: FragmentManager) {
        if (!loadingIsShow) {
            loadingIsShow = true
            Log.d("Hasiy", "showBaseProgressBar")
            spinkitProgressBarDialog.show(supportFragmentManager, "showSpinkitProgressBarDialog")
        }
    }

    fun dismissSpinkitProgressBarDialog() {
        if (loadingIsShow) {
            loadingIsShow = false
            spinkitProgressBarDialog.dismiss()
        }
    }

}