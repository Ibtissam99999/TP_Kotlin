package com.example.mykotlinapp.TP4

fun String.removeFirstLastChar():String= this.substring(1,this.length-1)
fun main(args:Array<String>){
    val myString="HelloEveryone"
    val result=myString.removeFirstLastChar()
    println("Firstcharacteris:$result")
}
