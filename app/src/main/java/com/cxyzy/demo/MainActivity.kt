package com.cxyzy.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cxyzy.library.WindmillActivity
import com.cxyzy.utils.ext.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity<WindmillActivity>()
    }
}
