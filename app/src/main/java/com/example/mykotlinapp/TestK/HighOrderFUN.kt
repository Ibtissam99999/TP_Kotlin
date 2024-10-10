package com.example.mykotlinapp.TestK

import java.util.Arrays

fun calcul (nambers:Array<Int>,fn : (Int)->Boolean):Array<Int>{

    val nb= mutableListOf<Int>()
    for(n in nambers){
        if (fn(n)){
            nb.add(n)
        }

    }
    return nb.toTypedArray()
}

fun nombrePositive(a:Int):Boolean{
    return a>0
}
fun evenNambers (a:Int):Boolean{
    return a%2 ==0
}

fun main(){
    val num= arrayOf(-2,-90,-10,3,5,6,12,34,-8,20)
    val numPositive= calcul(num,::nombrePositive)
    println("${Arrays.toString(numPositive)}")

    val numPair= calcul(num,::evenNambers)

    println("${Arrays.toString(numPair)}")

    val nbPairetPositive = calcul (
        calcul(num, ::nombrePositive) ,
        ::evenNambers)
        println(Arrays.toString(nb))

    }
