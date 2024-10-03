package com.example.mykotlinapp.TP1


class Animal(val nom: String, val age: Int) {


    fun afficherDetails() {
        println("Nom de l'animal: $nom, Âge: $age ans")
    }
}

fun main() {

    val animal1 = Animal("Lion", 5)
    val animal2 = Animal("Éléphant", 10)


    animal1.afficherDetails()
    animal2.afficherDetails()
}
