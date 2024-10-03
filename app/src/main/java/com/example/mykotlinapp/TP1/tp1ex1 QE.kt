package com.example.mykotlinapp.TP1

fun main() {
    val numbers = mutableListOf<Double>()

    println("Entrez les nombres un par un. Entrez -1 pour terminer et calculer la moyenne.")

    while (true) {
        print("Entrez un nombre (ou -1 pour terminer) : ")
        val number = safeReadDouble()

        if (number == -1.0) {
            break
        }

        if (number >= 0) {
            numbers.add(number)
        } else {
            println("Les valeurs négatives ne sont pas acceptées. Essayez à nouveau.")
        }
    }

    if (numbers.isEmpty()) {
        println("Aucun nombre n'a été saisi.")
    } else {
        // Calculer la moyenne des nombres
        val moyenne = numbers.sum() / numbers.size

        // Afficher la moyenne calculée
        println("La moyenne des nombres est : $moyenne")

        // Afficher la mention correspondante
        val mention = when {
            moyenne >= 16 -> "Excellent"
            moyenne >= 14 -> "Très bien"
            moyenne >= 12 -> "Bien"
            moyenne >= 10 -> "Passable"
            else -> "Insuffisant"
        }

        println("Mention : $mention")
    }
}

// Fonction pour lire un nombre avec gestion des erreurs
fun safeReadDouble(): Double {
    while (true) {
        try {
            return readLine()!!.toDouble()
        } catch (e: NumberFormatException) {
            print("Entrée non valide. Veuillez entrer un nombre.")
        }
    }
}