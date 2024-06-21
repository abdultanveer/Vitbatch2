package com.example.vitbatch2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.example.vitbatch2.databinding.ActivityHomeBinding
import com.example.vitbatch2.databinding.ActivityHomeBindingImpl

class HomeActivity : AppCompatActivity() {
     //lateinit var brake:Int?
   // lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
         setContentView(R.layout.activity_home)

    }

    override fun onStart() {
        super.onStart()
    }

    fun insertDb(view: View) {}
}