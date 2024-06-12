package com.example.vitbatch2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity"

    //chick is getting created in the egg  --- memory is being allocated for the activity
    override fun onCreate(savedInstanceState: Bundle?) {  //method header or signature
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG,"activity created")
    }

    //chick has hatched  --- activity is visible for clicks
    override fun onStart() {
        super.onStart()
        Log.i(TAG,"activity started")

    }

    //chick has woken up -- come back to the foreground
    override fun onResume() {
        super.onResume()
        Log.i(TAG,"activity resumed")

    }

    //chick has slept  --is partially visible -- background
    override fun onPause() {
        super.onPause()
        Log.i(TAG,"activity paused")

    }

    //activity hibernated
    override fun onStop() {
        super.onStop()
        Log.i(TAG,"activity stopped")

    }

    //all the resources are purged
    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"activity destroyed")

    }


    fun myClickHandler(view: View) {
        Log.i("MainActivity","button clicked")
        //implicit intent ..not taking the name of the class to be invoked
      //  var dialIntent:Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:987654398765"))
        /*var webIntent:Intent = Intent(Intent.ACTION_VIEW,Uri.parse("http://www.yahoo.com"))
        startActivity(webIntent)*/
        //createAlarm("vit",19,32) //vit, 19, 32 are my arguments

        //context == history
        //explicigt intent = HomeActivity reference name
        var hIntent = Intent(this,HomeActivity::class.java)
        hIntent.putExtra("nkey","abdul-android")
        startActivity(hIntent)
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
}