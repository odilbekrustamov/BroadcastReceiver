package com.exsample.broadcastreceiver.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.Toast
import com.exsample.broadcastreceiver.utils.Extensions.showDialog

class NoticeUsbConnectionReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val plugged = intent!!.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
        if (plugged == BatteryManager.BATTERY_PLUGGED_USB) {
            Toast.makeText(context, "Connected to USB", Toast.LENGTH_LONG).show()
            showDialog(context)
        } else if (plugged == BatteryManager.BATTERY_PLUGGED_AC) {
            Toast.makeText(context, "Connected to Power", Toast.LENGTH_LONG).show()
        }
    }



}