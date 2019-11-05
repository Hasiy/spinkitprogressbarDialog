package top.hasiy.spinkitProgressBarDemo.view

import android.graphics.Color
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.hasiy.toastsDemo.R
import top.hasiy.spinkitProgressBarDemo.base.BaseActivity
import top.hasiy.spinkitProgressBarDemo.base.baseAdapter.OnItemClickListener
import top.hasiy.spinkitprogressbar.dialog.SpinkitProgressBarDialogConfig
import java.util.*

class MainActivity : BaseActivity() {
    private lateinit var itemAdapter: SpinkitItemAdapter
    private var itemInfo: List<ItemData> = listOf(
        ItemData(Color.parseColor("#2AF598"), "RotatingPlane"),
        ItemData(Color.parseColor("#FFE32C"), "DoubleBounce"),
        ItemData(Color.parseColor("#E0C3FC"), "Wave"),
        ItemData(Color.parseColor("#8EC5FC"), "WanderingCubes"),
        ItemData(Color.parseColor("#FA709A"), "Pulse"),
        ItemData(Color.parseColor("#F7CE68"), "ChasingDots"),
        ItemData(Color.parseColor("#FBAB7E"), "ThreeBounce"),
        ItemData(Color.parseColor("#3EECAC"), "Circle"),
        ItemData(Color.parseColor("#FF9A8B"), "CubeGrid"),
        ItemData(Color.parseColor("#4158D0"), "FadingCircle"),
        ItemData(Color.parseColor("#C850C0"), "FoldingCube"),
        ItemData(Color.parseColor("#9599E2"), "RotatingCircle"),
        ItemData(Color.parseColor("#F76B1C"), "Heartbeat")
    )

    override fun initUI() {
        setContentView(R.layout.activity_main)
        itemAdapter = SpinkitItemAdapter(this, itemInfo).apply {
            setOnItemClickListener(object : OnItemClickListener<ItemData> {
                override fun onItemClick(view: View, position: Int, item: ItemData) {
                    show(item)
                }
            })
        }
        rv_item_spinkit.layoutManager = GridLayoutManager(this, 2)
        rv_item_spinkit.adapter = itemAdapter
    }

    private fun show(info: ItemData) {
        val timer = Timer()
        SpinkitProgressBarDialogConfig.instance
            .messageShow(true)
            .spinKitColor(info.itemColor)
            .spinKitStatus(info.itemName)
            .apply()
        showBaseProgressBar("正在加载喽~~")
        timer.schedule(object : TimerTask() {
            override fun run() {
                dismissBaseProgressBar()
            }
        }, 5000)
    }

}
