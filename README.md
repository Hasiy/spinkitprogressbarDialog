# spinkitprogressbarDialog

> Android 加载 ProgressBarDialog 基于spinkit动画(参照[SpinKit](https://github.com/Hasiy/Android-SpinKit)）

> 基于DialogFragment 不会发生 WindowLeaked 错误

## 效果

<img src="http://ww1.sinaimg.cn/large/8c95cb62gy1g8napr4cu1j20u01qcn0l.jpg" width="270px" height="561px"/>

<img src="http://ww1.sinaimg.cn/large/8c95cb62gy1g8nap2n7ajj20u01qcjv7.jpg" width="270px" height="561px"/>

##  Gradle 设置

 ``` gradle
dependencies {
       implementation 'top.hasiy:spinkitprogressbar:1.3.0'
 }
 ```

## 使用

- BaseActivity
```Kotlin
abstract class BaseActivity : AppCompatActivity(), SpinkitProgressBarDialogManager {
override var loadingIsShow: Boolean = false
override lateinit var spinkitProgressBarDialog: SpinkitProgressBarDialog
    
    //初始化Dialog
    override fun onStart() {
        SpinkitProgressBarDialogConfig.instance
        .messageShow(true)
        // 是否显示加载文字
        .spinKitColor(Color.parseColor("#a1c4fd"))
        //设置spinKit显示颜色         
        .spinKitStatus("WanderingCubes")
        // 设置加载动画 
        .apply()
        //应用
        //SpinkitProgressBarDialogConfig.reset()  恢复默认设置
         super.onStart()
 	}

    private fun showProgressBar() {
      showSpinkitProgressBarDialog(supportFragmentManager)
    }

    fun showBaseProgressBar() {
    	//显示无文字 Dialog
    	SpinkitProgressBarDialogConfig.instance
        .messageShow(false)
        .spinKitColor(Color.parseColor("#a1c4fd"))
        .spinKitStatus("WanderingCubes")
        .apply()
        spinkitProgressBarDialog =
        SpinkitProgressBarDialog.instance("")
        showProgressBar()
    }

    fun showBaseProgressBar(text: String) {
        //显示文字 Dialog
         SpinkitProgressBarDialogConfig.instance
        .messageShow(true)
        .spinKitColor(Color.parseColor("#a1c4fd"))
        .spinKitStatus("WanderingCubes")
        .apply()
        spinkitProgressBarDialog =	
        SpinkitProgressBarDialog.instance(text)
        showProgressBar()
    }

    //关闭 Dialog
    fun dismissBaseProgressBar() {
        if (!this.isDestroyed && !this.isFinishing) {
            dismissSpinkitProgressBarDialog()
        }
    }
    
}
```


- 其他Activity 调用

    显示 ：        showBaseProgressBar()  ||  showBaseProgressBar("加载中...")
    关闭 ：        dismissBaseProgressBar()
### 调用Demo：
<img src="https://s2.ax1x.com/2019/06/19/VOfsB9.jpg" width="300px" height="600px"/>

### SpinKitStatus样式:

| 样式           | 预览                                                         |
| -------------- | ------------------------------------------------------------ |
| RotatingPlane  | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/RotatingPlane.gif' alt='RotatingPlane' width="90px" height="90px"/> |
| DoubleBounce   | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/DoubleBounce.gif' alt='DoubleBounce' width="90px" height="90px"/> |
| Wave           | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/Wave.gif' alt='Wave' width="90px" height="90px"/> |
| WanderingCubes | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/WanderingCubes.gif' alt='WanderingCubes' width="90px" height="90px"/> |
| Pulse          | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/Pulse.gif' alt='Pulse' width="90px" height="90px"/> |
| ChasingDots    | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/ChasingDots.gif' alt='ChasingDots' width="90px" height="90px"/> |
| ThreeBounce    | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/ThreeBounce.gif' alt='ThreeBounce' width="90px" height="90px"/> |
| Circle         | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/Circle.gif' alt='Circle' width="90px" height="90px"/> |
| CubeGrid       | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/CubeGrid.gif' alt='CubeGrid' width="90px" height="90px"/> |
| FadingCircle   | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/FadingCircle.gif' alt='FadingCircle' width="90px" height="90px"/> |
| FoldingCube    | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/FoldingCube.gif' alt='FoldingCube' width="90px" height="90px"/> |
| RotatingCircle | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/RotatingCircle.gif' alt='RotatingCircle' width="90px" height="90px"/> |
| Heartbeat        | <img src='http://ww1.sinaimg.cn/large/8c95cb62gy1g679fzbszeg208w08ytge.gif' alt='Heartbeat' width="95px" height="90px"/>|

## Library used

- [Android-SpinKit](https://github.com/Hasiy/Android-SpinKit).