package com.example.mykotlinapp.TestK

fun arrayActions (array:Array<Int> ,action:(Int) -> Unit){
    for (a in array){
        action(a)
    }
}

fun main(){
    val numbers = arrayOf(-99,-42,-6,-5,0,18,87,119)
    numbers.filter { numbers->numbers>0 }
    numbers.filter { it>0 }
    numbers.filter { it %2==0 }
    println("Lambds :equivalent of numbers .forEach {}")
        arrayActions(numbers){numbers-> println(numbers) }
    println("Lambda :underscore for unuse variables")
    numbers.forEachIndexed { index, number -> println("l'index: $index,nombre $number")  }
    numbers.forEachIndexed({_,number -> print(number)})

}