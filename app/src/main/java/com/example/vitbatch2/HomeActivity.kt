package com.example.vitbatch2

import android.os.Bundle
import android.view.View
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.vitbatch2.database.Item
import com.example.vitbatch2.database.ItemDao
import com.example.vitbatch2.database.ItemRoomDatabase
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    lateinit var itemDao: ItemDao
    lateinit var tvHome:TextView
   // var count = 0
    lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
         setContentView(R.layout.activity_home)
        tvHome = findViewById(R.id.tvHome)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel._seconds.observe(this, secsObserver);                 //like clicking the bell icon on youtube

       // tvHome.setText(""+viewModel.count)
        var  database = ItemRoomDatabase.getDatabase(this)
        itemDao = database.itemDao()


    }



    fun insertDb(view: View) {
        GlobalScope.launch {
            val item = Item(777,"fruits",111.0,22)
            itemDao.insert(item)

        }
    }

    fun findItemDb(view: View) {
        GlobalScope.launch(Dispatchers.Main) {
            val item = itemDao.getItem(777).first()
            tvHome.setText(item.itemName)
        }
    }

    var secsObserver : Observer<Int> = object :Observer<Int>{
        override fun onChanged(value: Int) {
            //receiving the update/notification
            tvHome.setText(value.toString())
        }
    }

    fun incrementCount(view: View) {
       viewModel.startTimer()
    }
}