package com.cxyzy.lib.ui.windmill

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.view_double_windmill.view.*
import kotlinx.android.synthetic.main.view_double_windmill.view.windmillBladeIv

/**
 * 两个风车旋转
 */
class DoubleWindmillView constructor(context: Context, attrs: AttributeSet? = null) :
    BaseWindmillView(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.view_double_windmill, this, true)
    }

    override fun getToRotateViews()= listOf(windmillBladeIv,smallWindmillBladeIv)

}
