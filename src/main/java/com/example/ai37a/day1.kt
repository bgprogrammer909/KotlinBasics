package com.example.ai37a

import androidx.compose.animation.scaleOut
import androidx.core.graphics.red
import kotlin.random.Random

fun main() {
//    val name : String="suchit"
//    val age:Int=20
//    println("My name is ${name.uppercase()} and age is $age")
//*************practice from below*****************

// ARRAY BELOW ************************************************
//    var age=arrayOf(11,23,34)
//    age[0]=13
//    print(age[0])

//    var names=arrayOf("suchit","kunjang", "Samuel")
//    names[0]="Suchit RB"
//    print(names[0])

//      var names=arrayListOf<String>("suchit","samuel","kunjang")
//      names.add("shrijan")
//      names.add(4,"abhikal")
//      names.remove("suchit")
//      names.removeAt(1)
//      println(names)

//      var mixedArraylist=arrayListOf<Any>("ME",1,3.0)
//      println(mixedArraylist[0])
//      println(mixedArraylist[1])
//      println(mixedArraylist[2])

// kotlin collection overview task below ************************
//val numbers : List<String> = listOf("one","two","three")
//println("Number of elements: ${numbers.size}")
//println("the third element is : ${numbers.get(2)}")
//println("the third number is ${numbers[2]}")
//println("Index of element \"two\" ${numbers.indexOf("two")} ")


// Create a Dictionary app using mapOf() function where user will
// type a word and your program should return the meaning of that word.
//    val dictionary = mapOf(
//        "apple" to "red juicy fruit",
//        "walk" to "to move forward",
//        "water" to "liquid that gives life; h20")
//    println("enter the word")
//    val input: String = readln().lowercase()
//    println("the meaning of $input is ${dictionary[input]} ")
//
//

//println("Enter number to get respective day")
//    val day: Int = readln()!!.toInt()
//        var answer:String
//    when(day){
//        1 -> answer="sunday"
//        2 -> answer="monday"
//        3 -> answer="tuesday"
//        4 -> answer="wednesday"
//        5 -> answer="thursday"
//        6 -> answer="friday"
//        7 -> answer="saturday"
//        else -> answer="not valid"
//    }
//    println(answer)

//   ********RANDOM NUBER GUESSING GAME**********
//    var ran = (1..10).random()
//    println("enter a number between 1 to 100")
//    var answer:Int
//    do {
//        var answer: Int = readln().toInt()
//        if (ran > answer) {
//            println("try a bit higher")
//        }else if (ran < answer) {
//            println("try a bit lower")
//        }
//    }while(answer!=ran)
//        println("correct guess the number was $ran")

add(5,6)
    tableOf(8)
}

//***********Functions below
fun add(a:Int, b:Int):Unit{
    println("sum is ${a+b}")

}
fun tableOf(a:Int):Unit{

    for (i in 1..10 step 1){
        println("$a x $i = ${a*i}")
    }
}

