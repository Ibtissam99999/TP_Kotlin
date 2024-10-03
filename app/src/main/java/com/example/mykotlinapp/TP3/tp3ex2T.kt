package com.example.mykotlinapp.TP3

// 1.
data class Etape(
    val nom: String,
    val dateDebut: String,
    val dateFin: String,
    val distance: Int,
    val difficulte: String
)

// 2.
sealed class Resultat {
    data class Termine(val tempsEffectue: Int, val classement: Int) : Resultat()
    data class Abandonne(val distanceParcourue: Int, val raison: String) : Resultat()
}

// 3.
class Cycliste(
    val nom: String,
    val prenom: String,
    val nationalite: String,
    val age: Int
) {

    private val historiqueEtapes = hashMapOf<Etape, Resultat>()


    fun nouvelleEtape(etape: Etape, resultat: Resultat) {
        historiqueEtapes[etape] = resultat
    }

    override fun toString(): String {
        val etapesInfo = historiqueEtapes.entries.joinToString("\n") { (etape, resultat) ->
            val res = when (resultat) {
                is Resultat.Termine -> "Terminé en ${resultat.tempsEffectue} minutes, classement: ${resultat.classement}"
                is Resultat.Abandonne -> "Abandonné après ${resultat.distanceParcourue} km, raison: ${resultat.raison}"
            }
            "${etape.nom} (${etape.dateDebut} - ${etape.dateFin}, ${etape.distance} km, ${etape.difficulte}) -> $res"
        }
        return "Cycliste: $prenom $nom, $age ans, $nationalite\nHistorique des étapes:\n$etapesInfo"
    }
}

fun main() {
    val etape1 = Etape("etape1", "01-10-2024", "01-10-2024", 120, "Difficile")
    val etape2 = Etape("etape2", "02-10-2024", "02-10-2024", 90, "Facile")
    val etape3 = Etape("etape3", "03-10-2024", "03-10-2024", 110, "Moyenne")

    val cycliste = Cycliste("NomC", "PreomC", "Maroc", 28)

    cycliste.nouvelleEtape(etape1, Resultat.Termine(180, 2))
    cycliste.nouvelleEtape(etape2, Resultat.Abandonne(45, "Fatigue"))
    cycliste.nouvelleEtape(etape3, Resultat.Termine(150, 5))

    println(cycliste)
}