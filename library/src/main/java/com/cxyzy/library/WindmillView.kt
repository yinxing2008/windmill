package com.cxyzy.library

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.LinearLayout
import androidx.annotation.IntRange
import kotlinx.android.synthetic.main.view_windmill.view.*

class WindmillView constructor(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {
    private var mRotateSpeed = 1

    init {
        LayoutInflater.from(context).inflate(R.layout.view_windmill, this, true);
    }

    fun startRotate() {
        val animateTime = getAnimateTimeFromSpeed()
        val animation = RotateAnimation(
            0f, 360f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        animation.fillAfter = true
        animation.repeatCount = Animation.INFINITE
        animation.duration = animateTime
        animation.interpolator = LinearInterpolator()
        windmillBladeIv.startAnimation(animation)
    }

    fun setRotateSpeed(@IntRange(from = 1, to = 10) rotateSpeed: Int) {
        mRotateSpeed = rotateSpeed
    }

    private fun getAnimateTimeFromSpeed(): Long {
        return (10 * 1000 / mRotateSpeed).toLong()
    }
}