package com.example.vitbatch2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val message = Telephony.Sms.Intents.getMessagesFromIntent(intent)
        val content =  message[0].displayMessageBody
       // if(content.startsWith("command-- get location")) //send sms to the theif's phno


        val phno = message[0].displayOriginatingAddress
       Log.i("SmsReceiver","hi abdul you've an sms"+ content+phno)
    }
}