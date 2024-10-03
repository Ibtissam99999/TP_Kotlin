package com.example.mykotlinapp.TP1

open class Forme(val couleur: String) {

    open fun afficherCouleur() {
        println("Couleur de la forme: $couleur")
    }
}

class Cercle(couleur: String, val rayon: Double) : Forme(couleur) {

    fun aire(): Double {
        return Math.PI * rayon * rayon
    }

    fun afficherDetails() {
        super.afficherCouleur()
        println("Rayon du cercle: $rayon")
        println("Aire du cercle: ${aire()}")
    }
}

class Rectangle(couleur: String, val largeur: Double, val hauteur: Double) : Forme(couleur) {

    fun aire(): Double {
        return largeur * hauteur
    }

    fun afficherDetails() {
        super.afficherCouleur()
        println("Largeur du rectangle: $largeur")
        println("Hauteur du rectangle: $hauteur")
        println("Aire du rectangle: ${aire()}")
    }
}

fun main() {
    val cercle = Cercle("Rouge", 5.0)
    cercle.afficherDetails()

    println()

    val rectangle = Rectangle("Bleu", 4.0, 6.0)
    rectangle.afficherDetails()
}
