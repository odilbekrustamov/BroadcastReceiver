package com.exsample.broadcastreceiver.service

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import android.util.Log


class ScreenListenerService : Service() {
    private val mScreenStateBroadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            if (intent.action == Intent.ACTION_SCREEN_ON) {

                Log.d("TAG", "onReceive: on")
            } else if (intent.action == Intent.ACTION_SCREEN_OFF) {

                Log.d("TAG", "onReceive: off")
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_SCREEN_ON)
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF)
        registerReceiver(mScreenStateBroadcastReceiver, intentFilter)
    }

    override fun onDestroy() {
        unregisterReceiver(mScreenStateBroadcastReceiver)
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}