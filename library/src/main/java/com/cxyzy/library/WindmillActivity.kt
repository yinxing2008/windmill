package com.cxyzy.library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_windmill.*

/**
 * 动画样例：风车不停旋转
 */
class WindmillActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_windmill)
        windmillView.setRotateSpeed(1)
        windmillView.startRotate()
    }

}
