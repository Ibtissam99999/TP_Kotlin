package com.example.mykotlinapp.TestK

class Car(val wheelsCount: Int) {
    inner class Engine {
        fun displayHorsepower() {
            println("La voiture a ${wheelsCount * 34} chevaux")
        }
    }
}

fun main() {
    val car = Car(4)
    val engine = car.Engine()  // Utilisation correcte de l'instance de la classe interne
    engine.displayHorsepower() // Appel de la méthode de la classe interne
}

