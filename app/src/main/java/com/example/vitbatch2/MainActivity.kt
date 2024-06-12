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
        Log.i(TAG,"activity created -- memory allocations")
    }

    //chick has hatched  --- activity is visible for clicks
    override fun onStart() {
        super.onStart()
        Log.e(TAG,"activity started -- initialize  data")
    }

    //chick has woken up -- come back to the foreground
    override fun onResume() {
        super.onResume()
        Log.w(TAG,"activity resumed --restore state of the app")
    }

    //chick has slept  --is partially visible -- background
    override fun onPause() {
        super.onPause()
        Log.d(TAG,"activity paused --store the app state")
    }

    //activity hibernated
    override fun onStop() {
        super.onStop()
        Log.v(TAG,"activity stopped")
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
}