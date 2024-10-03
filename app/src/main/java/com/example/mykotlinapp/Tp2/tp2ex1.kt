package com.example.mykotlinapp.Tp2

class Langues(val id: Int, val nom: String)

class Etudiant(val prenom: String, val age: Int, val langues: List<Langues>) {

    fun afficherDetails() {
        println("L'étudiant : $prenom, $age ans.")
        print("Langues maîtrisées : ")
        println(langues.joinToString(", ") { it.nom })
        println("=======================================")
    }
}

fun main() {
    val arabe = Langues(1, "Arabe")
    val francais = Langues(2, "Français")
    val anglais = Langues(3, "Anglais")
    val espagnol = Langues(4, "Espagnol")

    val etudiant1 = Etudiant("Ahmed", 22, listOf(arabe, francais, anglais))
    val etudiant2 = Etudiant("Yassine", 18, listOf(arabe, francais))
    val etudiant3 = Etudiant("Khalid", 20, listOf(anglais, espagnol))

    etudiant1.afficherDetails()
    etudiant2.afficherDetails()
    etudiant3.afficherDetails()
}