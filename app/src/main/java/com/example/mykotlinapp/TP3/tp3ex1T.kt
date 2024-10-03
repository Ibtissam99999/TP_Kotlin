package com.example.mykotlinapp.TP3

// Partie 1

// 1.

data class Joueure(
    val nom: String,
    val numero: Int,
    val equipe: String,
    var points: Int
)
enum class Equipee {
    OCS, OCK
}

data class JoueurEnum(
    val nom: String,
    val numero: Int,
    val equipe: Equipee,
    var points: Int
)

data class JoueurCompetition(
    val nom: String,
    val numero: Int,
    var points: Int
)

class EquipeCompetition(
    private val pays: Pays,
    val sigle: String,

    ) {
    private val joueurs: MutableList<JoueurCompetition> = mutableListOf()
    fun ajout(j: JoueurCompetition): Boolean {
        return if (recherche(j.nom) == -1) {
            joueurs.add(j)
            true
        } else {
            false
        }
    }

    fun recherche(nomJoueur: String): Int {
        return joueurs.indexOfFirst { it.nom.equals(nomJoueur, ignoreCase = true) }
    }

    fun suppression(j: JoueurCompetition): Boolean {
        val index = recherche(j.nom)
        return if (index != -1) {
            joueurs.removeAt(index)
            true
        } else {
            false
        }
    }

    fun affichage() {
        println("Équipe: $sigle ($pays)")
        joueurs.forEach { println(it) }
    }

    fun setPoints(nomJoueur: String, points: Int): Boolean {
        val index = recherche(nomJoueur)
        return if (index != -1) {
            joueurs[index].points = points
            true
        } else {
            false
        }
    }
}

fun main() {
    val joueurs = mutableListOf(
        Joueure(nom = "J1", numero = 7, equipe = "OCS", points = 15),
        Joueure(nom = "J2", numero = 12, equipe = "OCK", points = 20),
        Joueure(nom = "J3", numero = 23, equipe = "OCS", points = 18)
    )

    println("Liste initiale des joueurs:")
    joueurs.forEach { println(it) }

    val joueur4 = Joueure(nom = "J4", numero = 34, equipe = "OCK", points = 22)
    joueurs.add(joueur4)

    println("\nAprès l'ajout du quatrième joueur:")
    joueurs.forEach { println(it) }

    // Partie 2

    val joueursEnum = mutableListOf(
        JoueurEnum(nom = "Alice", numero = 7, equipe = Equipee.OCS, points = 15),
        JoueurEnum(nom = "Bob", numero = 12, equipe = Equipee.OCK, points = 20),
        JoueurEnum(nom = "Charlie", numero = 23, equipe = Equipee.OCS, points = 18)
    )

    val joueur4Enum = JoueurEnum(nom = "Diana", numero = 34, equipe = Equipee.OCK, points = 22)
    joueursEnum.add(joueur4Enum)

    println("\nListe des joueurs avec enum Equipe:")
    joueursEnum.forEach { println(it) }

    // Partie 3

    val equipe1 = EquipeCompetition(Pays.MAROC, "WAC")
    val equipe2 = EquipeCompetition(Pays.TUNISIE, "RCA")
    val equipe3 = EquipeCompetition(Pays.ALGERIE, "RCA")
    val equipe4 = EquipeCompetition(Pays.MAURITANIE, "WAC")

    val equipes = listOf(equipe1, equipe2, equipe3, equipe4)


    val joueurA = JoueurCompetition(nom = "Ali", numero = 9, points = 25)
    val joueurB = JoueurCompetition(nom = "Brahim", numero = 11, points = 30)
    val joueurC = JoueurCompetition(nom = "Cyrine", numero = 5, points = 20)
    val joueurD = JoueurCompetition(nom = "David", numero = 7, points = 18)

    println("\nAjout de joueurs aux équipes:")
    println("Ajout de ${joueurA.nom} à ${equipe1.sigle}: ${equipe1.ajout(joueurA)}")
    println("Ajout de ${joueurB.nom} à ${equipe2.sigle}: ${equipe2.ajout(joueurB)}")
    println("Ajout de ${joueurC.nom} à ${equipe3.sigle}: ${equipe3.ajout(joueurC)}")
    println("Ajout de ${joueurD.nom} à ${equipe4.sigle}: ${equipe4.ajout(joueurD)}")

    println("Tentative d'ajout de ${joueurA.nom} à ${equipe1.sigle}: ${equipe1.ajout(joueurA)}")

    println("\nAffichage des équipes après ajout:")
    equipes.forEach { it.affichage() }

    println("\nRecherche de 'Brahim' dans l'équipe ${equipe2.sigle}: Indice = ${equipe2.recherche("Brahim")}")
    println("Recherche de 'Eve' dans l'équipe ${equipe2.sigle}: Indice = ${equipe2.recherche("Eve")}") // -1

    println("\nSuppression de 'Cyrine' de l'équipe ${equipe3.sigle}: ${equipe3.suppression(joueurC)}")
    println("Suppression de 'Eve' de l'équipe ${equipe3.sigle}: ${equipe3.suppression(
        JoueurCompetition("Eve", 0, 0)
    )}")

    println("\nAffichage des équipes après suppression:")
    equipes.forEach { it.affichage() }

    println("\nMise à jour des points de 'Ali' à 28: ${equipe1.setPoints("Ali", 28)}")
    println("Mise à jour des points de 'Eve' à 10: ${equipe1.setPoints("Eve", 10)}")

    println("\nAffichage final des équipes après mise à jour des points:")
    equipes.forEach { it.affichage() }
}