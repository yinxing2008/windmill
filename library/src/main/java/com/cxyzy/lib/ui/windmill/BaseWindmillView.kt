package com.cxyzy.lib.ui.windmill

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.LinearLayout
import androidx.annotation.IntRange

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