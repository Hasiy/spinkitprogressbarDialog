package top.hasiy.spinkitProgressBarDemo.view

import android.content.Context
import com.hasiy.toastsDemo.R
import kotlinx.android.synthetic.main.rv_item_spink_tip.view.*
import top.hasiy.spinkit.style.*
import top.hasiy.spinkitProgressBarDemo.base.baseAdapter.BaseRecyclerAdapter
import top.hasiy.spinkitProgressBarDemo.base.baseAdapter.BaseViewHolder

/*
 * @Author: Hasiy
 * @Date: 2019/11/5 - 15 : 27 
 * @Description: dialogspinkit
 * @Email: Zhuxs@venpoo.com
 */
class SpinkitItemAdapter(context: Context, data: List<ItemData>) :
    BaseRecyclerAdapter<ItemData>(context, R.layout.rv_item_spink_tip, data) {
    override fun convert(holder: BaseViewHolder, position: Int, item: ItemData, listSize: Int) {
        holder.setText(R.id.effect_description, item.itemName)
        val spinKit = when (item.itemName) {
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
        holder.itemView.iv_spinkit.setIndeterminateDrawable(spinKit)
        holder.itemView.iv_spinkit.setColor(item.itemColor)
    }
}