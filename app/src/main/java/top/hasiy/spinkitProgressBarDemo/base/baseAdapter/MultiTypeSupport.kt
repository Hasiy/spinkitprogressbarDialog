package top.hasiy.spinkitProgressBarDemo.base.baseAdapter

/**
 * Description:
 * Data：2019/1/28
 * Actor:Steven
 */
interface MultiTypeSupport<T> {
    fun getLayoutId(item: T, position: Int): Int
}