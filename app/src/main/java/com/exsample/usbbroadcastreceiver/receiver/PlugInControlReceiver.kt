package com.exsample.usbbroadcastreceiver.receiver

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast
import com.exsample.usbbroadcastreceiver.utils.Extensions
import com.exsample.usbbroadcastreceiver.utils.Extensions.showDialog


class PlugInControlReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent) {
        val action = intent.action
        Log.v("PlugInControlReceiver", "action: $action")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (action == "android.hardware.usb.action.USB_STATE") {
                if (intent.extras!!.getBoolean("connected")) {
                    Toast.makeText(context, "USB Connected", Toast.LENGTH_SHORT).show()
                    showDialog(context)
                } else {
                    Toast.makeText(context, "USB Disconnected", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            if (action == Intent.ACTION_POWER_CONNECTED) {
                Toast.makeText(context, "USB Connected", Toast.LENGTH_SHORT).show()
                showDialog(context)
            } else if (action == Intent.ACTION_POWER_DISCONNECTED) {
                Toast.makeText(context, "USB Disconnected", Toast.LENGTH_SHORT).show()
            }
        }
    }
}