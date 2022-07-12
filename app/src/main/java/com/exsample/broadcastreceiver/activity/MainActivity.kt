package com.exsample.broadcastreceiver.activity

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.exsample.broadcastreceiver.databinding.ActivityMainBinding
import com.exsample.broadcastreceiver.receiver.AirplaneModeChangedReceiver
import com.exsample.broadcastreceiver.receiver.NoticeUsbConnectionReceiver
import com.exsample.broadcastreceiver.service.ScreenListenerService





class MainActivity : AppCompatActivity() {
//    private lateinit var receiver : NoticeUsbConnectionReceiver
    private lateinit var airplaneModeChangedReceiver: AirplaneModeChangedReceiver

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
//        receiver = NoticeUsbConnectionReceiver()
        airplaneModeChangedReceiver = AirplaneModeChangedReceiver()

        val filter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(airplaneModeChangedReceiver, filter)

        val intent = Intent(this, ScreenListenerService::class.java)
        startService(intent)
    }

    override fun onStart() {
        super.onStart()
//        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
//        registerReceiver(receiver, filter)
    }

    override fun onStop() {
        super.onStop()
//        unregisterReceiver(receiver)
    }
}