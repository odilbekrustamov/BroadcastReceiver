package com.exsample.broadcastreceiver.utils

import android.app.AlertDialog
import android.content.Context

object Extensions {

    fun showDialog(context: Context?) {
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle("Warning!")
        dialog.setMessage("You are using USB to debugging!\nPlease unplug your phone from the computer!!!")
        dialog.setCancelable(false)
        dialog.setPositiveButton(
            "Ok"
        ) { _, _ -> throw Exception() }
        dialog.show()
    }

}