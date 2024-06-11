package com.example.vitbatch2.kotlinegs

import com.example.vitbatch2.Employee
import com.example.vitbatch2.Student

/*fun main() {
   var someLamda : (Int,Int) -> Int = {a:Int,b:Int -> a+b}
    println(someLamda(10,20))
   // var otherLamda : (Int,Int,String) -> Int = {a:Int,b:Int,msg:String -> println(msg) a+b}
}*/

var lamda : (Int) -> Int = { a -> a*a}

fun operation(): (Int) -> Int {                                     // 1
   // return lamda
    return ::square
}

fun square(x: Int) = x * x                                          // 2

fun main() {
    val func = operation()                                          // 3
    println(func(2))                                                // 4
}