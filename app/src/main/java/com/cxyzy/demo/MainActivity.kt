package com.cxyzy.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val minSpeed = 1
    private val maxSpeed = 10
    var speed = minSpeed
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startAnimation()
        accelerateBtn.setOnClickListener { accelerate() }
        slowDownBtn.setOnClickListener { slowDown() }
    }

    private fun accelerate() {
        if (speed < maxSpeed) {
            speed++
        }
        speedTv.text = speed.toString()
        startAnimation()
        updateButtons()
    }

    private fun slowDown() {
        if (speed > minSpeed) {
            speed--
            speedTv.text = speed.toString()
            startAnimation()
        }
        updateButtons()
    }

    private fun startAnimation() {
        doubleWindmillView.startRotate(speed)
    }

    private fun updateButtons() {
        accelerateBtn.isEnabled = speed < maxSpeed
        slowDownBtn.isEnabled = speed > minSpeed
    }
}
