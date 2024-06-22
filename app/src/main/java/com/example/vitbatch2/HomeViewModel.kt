package com.example.vitbatch2

import androidx.lifecycle.ViewModel

class HomeViewModel:ViewModel() {
    var count = 0

    fun incrementCount(){
        count++
    }
}