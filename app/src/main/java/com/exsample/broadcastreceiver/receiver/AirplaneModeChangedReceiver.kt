package com.exsample.broadcastreceiver.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangedReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent!!.getBooleanExtra("state", false)

        if (isAirplaneModeEnabled){
            Toast.makeText(context, "Airplane Mode enabled", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Airplane Mode disabled", Toast.LENGTH_SHORT).show()
        }
    }
}