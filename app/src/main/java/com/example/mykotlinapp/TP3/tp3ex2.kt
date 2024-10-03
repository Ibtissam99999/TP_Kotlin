data class Etape(
    val nom: String,
    val dateDebut: String,
    val dateFin: String,
    val distance: Int,
    val difficulte: String
)


data class Resultat(
    val tempsEffectue: Int,
    val classement: Int
)


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
            "${etape.nom} (${etape.dateDebut} - ${etape.dateFin}, ${etape.distance} km, ${etape.difficulte}) -> Terminé en ${resultat.tempsEffectue} minutes, classement: ${resultat.classement}"
        }
        return "Cycliste: $prenom $nom, $age ans, $nationalite\nHistorique des étapes:\n$etapesInfo"
    }
}

fun main() {
    val etape1 = Etape(
        nom = "etape1",
        dateDebut = "01-10-2024",
        dateFin = "01-10-2024",
        distance = 120,
        difficulte = "Difficile"
    )
    val etape2 = Etape(
        nom = "etape2",
        dateDebut = "02-10-2024",
        dateFin = "02-10-2024",
        distance = 90,
        difficulte = "Facile"
    )
    val etape3 = Etape(
        nom = "etape3",
        dateDebut = "03-10-2024",
        dateFin = "03-10-2024",
        distance = 110,
        difficulte = "Facile"
    )

    val cycliste = Cycliste(
        nom = "NomC1",
        prenom = "PrenomC1",
        nationalite = "Maroc",
        age = 28
    )

    cycliste.nouvelleEtape(etape1, Resultat(tempsEffectue = 180, classement = 2))
    cycliste.nouvelleEtape(etape2, Resultat(tempsEffectue = 200, classement = 5))
    cycliste.nouvelleEtape(etape3, Resultat(tempsEffectue = 150, classement = 3))

    println(cycliste)



    open class ResultatSealed

    data class Termine(
        val tempsEffectue: Int,
        val classement: Int
    ) : ResultatSealed()

    data class Abandonne(
        val distanceParcourue: Int,
        val raison: String
    ) : ResultatSealed()

    class CyclisteSealed(
        val nom: String,
        val prenom: String,
        val nationalite: String,
        val age: Int
    ) {
        private val historiqueEtapes = hashMapOf<Etape, ResultatSealed>()

        fun nouvelleEtape(etape: Etape, resultat: ResultatSealed) {
            historiqueEtapes[etape] = resultat
        }

        override fun toString(): String {
            val etapesInfo = historiqueEtapes.entries.joinToString("\n") { (etape, resultat) ->
                val res = when (resultat) {
                    is Termine -> "Terminé en ${resultat.tempsEffectue} minutes, classement: ${resultat.classement}"
                    is Abandonne -> "Abandonné après ${resultat.distanceParcourue} km, raison: ${resultat.raison}"
                    else -> {}
                }
                "${etape.nom} (${etape.dateDebut} - ${etape.dateFin}, ${etape.distance} km, ${etape.difficulte}) -> $res"
            }
            return "Cycliste: $prenom $nom, $age ans, $nationalite\nHistorique des étapes:\n$etapesInfo"
        }
    }

    val etape4 = Etape(
        nom = "etape4",
        dateDebut = "04-10-2024",
        dateFin = "04-10-2024",
        distance = 100,
        difficulte = "Difficile"
    )
    val etape5 = Etape(
        nom = "etape5",
        dateDebut = "05-10-2024",
        dateFin = "05-10-2024",
        distance = 130,
        difficulte = "Facile"
    )
    val etape6 = Etape(
        nom = "etape6",
        dateDebut = "06-10-2024",
        dateFin = "06-10-2024",
        distance = 95,
        difficulte = "Difficile"
    )


    val cyclisteSealed = CyclisteSealed(
        nom = "NomC2",
        prenom = "PrenomC2",
        nationalite = "Maroc",
        age = 30
    )


    cyclisteSealed.nouvelleEtape(etape4, Termine(tempsEffectue = 210, classement = 4))
    cyclisteSealed.nouvelleEtape(etape5, Abandonne(distanceParcourue = 60, raison = "Blessure"))
    cyclisteSealed.nouvelleEtape(etape6, Termine(tempsEffectue = 190, classement = 3))

    println("\n" + cyclisteSealed)
}