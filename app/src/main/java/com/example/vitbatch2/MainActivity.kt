package com.example.vitbatch2

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.provider.AlarmClock
import android.telephony.SmsManager
import android.util.Log
import android.view.View
import androidx.core.app.NotificationCompat
import java.time.Instant

class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity"

    //chick is getting created in the egg  --- memory is being allocated for the activity
    override fun onCreate(savedInstanceState: Bundle?) {  //method header or signature
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG,"activity created -- memory allocations")
    }



    fun myClickHandler(view: View) {
        Log.i("MainActivity","button clicked")
        //implicit intent ..not taking the name of the class to be invoked
      //  var dialIntent:Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:987654398765"))
        /*var webIntent:Intent = Intent(Intent.ACTION_VIEW,Uri.parse("http://www.yahoo.com"))
        startActivity(webIntent)*/
        //createAlarm("vit",19,32) //vit, 19, 32 are my arguments
        add(10,20)
        //context == history
        //explicigt intent = HomeActivity reference name
        var hIntent = Intent(this,HomeActivity::class.java)
        hIntent.putExtra("nkey","abdul-android")
        throw NullPointerException("homeactivity crash demo")

        startActivity(hIntent)
    }

    private fun add(i: Int, i1: Int): Int {
        var c = 5 *20;
        var d = c+i;
        repeat(3){
            c+=10
        }
        mul(5,4)
        return i + i1

    }

    private fun mul(i: Int, i1: Int) {
        div(9,3)
    }

    private fun div(i: Int, i1: Int) {
        subtract(10,5)
    }

    private fun subtract(i: Int, i1: Int) {
            i1-i
    }

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        //if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
       // }
    }

    fun showNotification(view: View) {
        createNotificationChannel()
        val intent = Intent(this, HomeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)


        var builder = NotificationCompat.Builder(this, "CHANNEL_ID")
            .setSmallIcon(R.drawable.baseline_account_balance_24)
            .setContentTitle("vit title")
            .setContentText("vit text android app dev")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)

        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(123,builder.build())
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is not in the Support Library.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "promotions channel name"
                //getString(R.string.channel_name)
            val descriptionText = "channel description"
                //getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system.
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun sendSms(view: View) {

        Log.i("HomeActivity","current system time in millis"+ SystemClock.elapsedRealtime())
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
       var triggerTime = System.currentTimeMillis()+30*60   //set the date and time of your friennds birthday
        //SystemClock.elapsedRealtime() + AlarmManager.INTERVAL_FIFTEEN_MINUTES

        val intent = Intent(this, HomeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        //alarmManager.canScheduleExactAlarms()
        alarmManager.set(AlarmManager.RTC,triggerTime,pendingIntent)

      //  alarmManager.setRepeating(AlarmManager.RTC,triggerTime,24*60*60*1000,pendingIntent)



    }
}