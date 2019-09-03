# windmill 旋转风车
博客：https://blog.csdn.net/yinxing2008/article/details/100260191
# 旋转风车实现效果
![](https://upload-images.jianshu.io/upload_images/6169789-7c37d152bf0b2255?imageMogr2/auto-orient/strip)
# 实现方案
对于风车的立柱部分，采用一张固定背景图；
对于风车上面旋转部分，采用一张图，通过安卓属性动画进行旋转。
注意点： 因为是采用两张图叠加而形成的效果，所以需要注意调整两张图的相对位置，使之刚好形成风车旋转效果。

# 主要代码
1. BaseWindmillView.kt
```
abstract class BaseWindmillView constructor(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {

    private fun getRotateAnimation(@IntRange(from = 1, to = 10) speed: Int): RotateAnimation {
        val animateTime = getAnimateTimeFromSpeed(speed)
        val animation = RotateAnimation(
            0f, 360f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        animation.fillAfter = true
        animation.repeatCount = Animation.INFINITE
        animation.duration = animateTime
        animation.interpolator = LinearInterpolator()
        return animation
    }

    private fun getAnimateTimeFromSpeed(speed: Int): Long {
        return (10 * 1000 / speed).toLong()
    }

    fun startRotate(@IntRange(from = 1, to = 10) speed: Int) {
        getToRotateViews().forEach {
            it.clearAnimation()
            it.startAnimation(getRotateAnimation(speed)) }
    }

    abstract fun getToRotateViews(): List<View>
}
```
2. DoubleWindmillView.kt
```
class DoubleWindmillView constructor(context: Context, attrs: AttributeSet? = null) :
    BaseWindmillView(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.view_double_windmill, this, true)
    }

    override fun getToRotateViews()= listOf(windmillBladeIv,smallWindmillBladeIv)

}
```
3. view_double_windmill.xml
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    android:orientation="vertical"
    tools:background="#1E90FF">

    <ImageView
        android:id="@+id/windmillBladeIv"
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:src="@mipmap/windmill_blade" />

    <ImageView
        android:layout_width="24dp"
        android:layout_height="80dp"
        android:layout_marginStart="29dp"
        android:layout_marginTop="32dp"
        android:src="@mipmap/windmill" />

    <ImageView
        android:id="@+id/smallWindmillBladeIv"
        android:layout_width="48dp"
        android:layout_height="48dp"
        android:layout_marginStart="50dp"
        android:layout_marginTop="30dp"
        android:src="@mipmap/windmill_blade" />

    <ImageView
        android:layout_width="14dp"
        android:layout_height="48dp"
        android:layout_marginStart="67dp"
        android:layout_marginTop="50dp"
        android:src="@mipmap/windmill" />

</RelativeLayout>
```
# lib库集成方法
1. 在工程根目录下build.gradle文件中增加jitpack仓库地址：
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
2. 在app工程下build.gradle文件中增加依赖：
```
dependencies {
    implementation 'com.github.cxyzy1:windmill:1.0.0'
}
```
