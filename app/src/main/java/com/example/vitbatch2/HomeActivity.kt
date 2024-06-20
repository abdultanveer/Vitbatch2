package com.example.vitbatch2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.vitbatch2.databinding.ActivityHomeBinding
import com.example.vitbatch2.network.MarsAdapter
import com.example.vitbatch2.network.MarsApi
import com.example.vitbatch2.network.MarsPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    //lateinit var brake:Int?
   // lateinit var recyclerview:RecyclerView
    lateinit var listMarsPhotos:List<MarsPhoto>
    lateinit var marsAdapter: MarsAdapter
   // lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_home)
       binding = ActivityHomeBinding.inflate(layoutInflater)
       val view = binding.root
       setContentView(view)

       // imageView = findViewById(R.id.imageView)
       // recyclerview = findViewById(R.id.recyclerView)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        listMarsPhotos = ArrayList<MarsPhoto>()
        marsAdapter = MarsAdapter(listMarsPhotos)
        binding.recyclerView.adapter = marsAdapter
       // brake
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
      //  if(intent.extras != null) {
            var data = intent.extras?.getString("nkey")
        Log.i("HomeActivity","data is = "+data)
        // val homeTextView:TextView = findViewById(R.id.tvHome)
       binding.tvHome.setText(data)
        // homeTextView.setText(data)

    }

    override fun onStart() {
        super.onStart()
        binding.btnGet.setOnClickListener{
            getMarsPhotos()
        }
    }



   /* fun getJson(view: View) {
        getMarsPhotos()
    }*/

    private fun getMarsPhotos() {
        GlobalScope.launch (Dispatchers.Main){
            //doing time taking tasks on the main thread is not advisable

            val listMarsPhoto = MarsApi.retrofitService.getPhotos()
            marsAdapter.listMarsPhotos = listMarsPhoto
            binding.imageView.load(listMarsPhoto.get(0).imgSrc)
           // imageView.load(listMarsPhoto.get(0).imgSrc)
            marsAdapter.notifyItemRangeChanged(0,listMarsPhoto.size)
          //  listMarsPhotos  = listMarsPhoto
            //marsAdapter.notifyDataSetChanged()
            Log.i("HomeActivity-1st imgsrc",listMarsPhoto.get(0).imgSrc)
        }

    }
}