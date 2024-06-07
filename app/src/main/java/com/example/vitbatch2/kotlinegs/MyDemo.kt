package com.example.vitbatch2.kotlinegs

import com.example.vitbatch2.Employee
import com.example.vitbatch2.Student

fun main() {
    println("hello world")
    var myStudent: Student = Student("abdul",12,"bangalore")
    println("name is "+ myStudent.name)
    myStudent.name = "ansari"
    println("name changed to "+ myStudent.name)

    var myEmployee: Employee = Employee("tanveer",21,"chennai")
    println("employee name is "+ myEmployee.name)


}