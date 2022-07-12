package com.exsample.usbbroadcastreceiver.activity

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.exsample.usbbroadcastreceiver.R
import com.exsample.usbbroadcastreceiver.receiver.NoticeUsbConnectionReceiver


class MainActivity : AppCompatActivity() {
    private lateinit var receiver : NoticeUsbConnectionReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        receiver = NoticeUsbConnectionReceiver()
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(receiver, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}