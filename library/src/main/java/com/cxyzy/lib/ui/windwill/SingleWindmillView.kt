package com.cxyzy.lib.ui.windwill

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.cxyzy.library.R
import kotlinx.android.synthetic.main.view_single_windmill.view.*

/**
 * 一个风车旋转
 */
class SingleWindmillView constructor(context: Context, attrs: AttributeSet? = null) :
    BaseWindmillView(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.view_single_windmill, this, true)
    }

    override fun getToRotateViews() = listOf(windmillBladeIv)
}
