package com.example.mykotlinapp.TestK

class ExempleLateinit {
    lateinit var nom: String
    fun initialiserNom(nouveauNom: String) {
        nom = nouveauNom
    }
    fun afficherNom() {
        if (::nom.isInitialized) {
            println("Le nom est : $nom")
        } else {
            println("Le nom n'est pas encore initialisé")
        }
    }
}
fun main() {
    val exemple = ExempleLateinit()
    exemple.afficherNom()  // Affiche : Le nom n'est pas encore initialisé
    exemple.initialiserNom("Kotlin")
    exemple.afficherNom()  // Affiche : Le nom est : Kotlin
}