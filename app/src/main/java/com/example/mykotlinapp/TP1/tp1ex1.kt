package com.example.mykotlinapp.TP1

fun main(){
    // 1. Demande à l'utilisateur de saisir un nombre n
    print("Entrez le nombre de valeurs à saisir : ")
    val n = readLine()!!.toInt()
    // 2. Invite l'utilisateur à entrer n nombres
    val Note = mutableListOf<Double>()
    for (i in 1..n) {
        print("Entrez la Note $i : ")
        val number = readLine()!!.toDouble()
        Note.add(number)
    }

    // 3. Calcule la moyenne de ces nombres.

val moyenne = Note .sum() / n

    // 4. Affiche la moyenne calculée.

    println("votre moyenne est $moyenne")

    //5. Affiche la mention correspondante en fonction de la moyenne obtenue

    // 5. Affiche la mention correspondante en fonction de la moyenne
    val mention = when {
        moyenne >= 16 -> "Excellent"
        moyenne >= 14 -> "Très bien"
        moyenne >= 12 -> "Bien"
        moyenne >= 10 -> "Passable"
        else -> "Insuffisant"
    }

    println("Mention:$mention")


}