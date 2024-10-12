//package com.example.mykotlinapp.TP4
//
//
////1
//fun MutableList<Int>.swap(index1 :Int ,index2: Int){
//    val tmp = this[index1]
//   this[index1]=this[index2]
//    this[index2]=tmp
//}
//
////2
//class Circle(val R: Double)
//
//fun Circle.perimeter(): Double {
//    return 2 * Math.PI * this.R
//}
//
//
////3
//
//class Student(val mark: Int)
//
//fun isPassed(mark: Int):Boolean{
//    return mark >40
//}
//
//fun Student.isExcellent(): Boolean {
//    return this.mark > 90
//}
//
//fun main() {
//val list= mutableListOf(1,0,9,4,5,3)
//    list.swap(0,2)
//    println("la nouvele list est :${list}")
//    val circle = Circle(5.0)
//    println("Le périmètre du cercle est : ${circle.perimeter()}")
//    val student = Student(95)
//    println("L'étudiant est excellent : ${student.isExcellent()}") }
//
//

// Définir la fonction compose
fun compose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int {
    return { x -> f(g(x)) }
}

fun main() {
    // Définir deux fonctions simples
    val multiplyByTwo = { x: Int -> x * 2 }
    val addThree = { x: Int -> x + 3 }

    // Composer les deux fonctions
    val composedFunction = compose(multiplyByTwo, addThree)

    // Tester la fonction composée
    println(composedFunction(4))  //  14, car (4 + 3) * 2 = 14
}

