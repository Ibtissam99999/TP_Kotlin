package com.example.mykotlinapp.TP3

// 1. Énumérations

enum class EquipeSigle {
    OCS, OCK, RCA, WAC
}

enum class Pays {
    MAROC, TUNISIE, ALGERIE, MAURITANIE
}

// 2. Classe Joueur

data class Joueur(
    val nom: String,
    val numero: Int,
    var points: Int
)

// 3. Classe Equipe avec les méthodes CRUD

class Equipe(
    private val pays: Pays,
    private val sigle: EquipeSigle,
    private val joueurs: MutableList<Joueur> = mutableListOf()
) {

    // Ajout d'un joueur. Retourne vrai si ajouté, faux si le joueur existe déjà
    fun ajout(j: Joueur): Boolean {
        return if (recherche(j.nom) == -1) {
            joueurs.add(j)
            true
        } else {
            false
        }
    }

    // Recherche d'un joueur par nom. Retourne l'indice ou -1 si non trouvé
    fun recherche(nom: String): Int {
        return joueurs.indexOfFirst { it.nom.equals(nom, ignoreCase = true) }
    }

    // Suppression d'un joueur. Retourne vrai si supprimé, faux sinon
    fun suppression(j: Joueur): Boolean {
        val index = recherche(j.nom)
        return if (index != -1) {
            joueurs.removeAt(index)
            true
        } else {
            false
        }
    }

    // Mise à jour d'un joueur. Remplace les informations du joueur existant par nouveauJoueur
    fun miseAJour(nom: String, nouveauJoueur: Joueur): Boolean {
        val index = recherche(nom)
        return if (index != -1) {
            joueurs[index] = nouveauJoueur
            true
        } else {
            false
        }
    }

    // Modification des points d'un joueur
    fun setPoints(j: Joueur, points: Int) {
        val index = recherche(j.nom)
        if (index != -1) {
            joueurs[index].points = points
        }
    }

    // Affichage des joueurs de l'équipe
    fun affichage() {
        println("Équipe ${sigle.name} (${pays.name}):")
        for (joueur in joueurs) {
            println("Nom: ${joueur.nom}, Numéro: ${joueur.numero}, Points: ${joueur.points}")
        }
        println()
    }
}

// 4. Fonction Principale

fun main() {
    // a. Création des équipes
    val equipe1 = Equipe(Pays.MAROC, EquipeSigle.OCS)
    val equipe2 = Equipe(Pays.ALGERIE, EquipeSigle.OCK)
    val equipe3 = Equipe(Pays.TUNISIE, EquipeSigle.RCA)
    val equipe4 = Equipe(Pays.MAURITANIE, EquipeSigle.WAC)

    // b. Ajout de joueurs aux équipes
    // Équipe OCS
    equipe1.ajout(Joueur("Ali", 10, 15))
    equipe1.ajout(Joueur("Ahmed", 12, 20))
    equipe1.ajout(Joueur("Sara", 9, 18))

    // Tentative d'ajout d'un joueur existant
    val ajoutExistant = equipe1.ajout(Joueur("Ali", 10, 15))
    println("Ajout d'Ali à OCS (déjà existant) : ${if (ajoutExistant) "Succès" else "Échec"}\n")

    // Équipe OCK
    equipe2.ajout(Joueur("Omar", 23, 20))
    equipe2.ajout(Joueur("Youssef", 9, 22))
    equipe2.ajout(Joueur("Lina", 11, 17))

    // Équipe RCA
    equipe3.ajout(Joueur("Hassan", 8, 30))
    equipe3.ajout(Joueur("Khalid", 5, 25))
    equipe3.ajout(Joueur("Maya", 7, 19))

    // Équipe WAC
    equipe4.ajout(Joueur("Yassine", 7, 28))
    equipe4.ajout(Joueur("Mounir", 13, 35))
    equipe4.ajout(Joueur("Nadia", 14, 21))

    // c. Affichage des équipes et joueurs
    equipe1.affichage()
    equipe2.affichage()
    equipe3.affichage()
    equipe4.affichage()

    // d. Modification des points d'un joueur
    println("Modification des points d'Ali dans l'équipe OCS.")
    val joueurAli = Joueur("Ali", 10, 15) // Les autres propriétés ne sont pas utilisées pour la recherche
    equipe1.setPoints(joueurAli, 50)
    equipe1.affichage()

    // e. Recherche d'un joueur
    val rechercheNom = "Sara"
    val indexSara = equipe1.recherche(rechercheNom)
    println("Recherche de $rechercheNom dans OCS : ${if (indexSara != -1) "Trouvé à l'indice $indexSara" else "Non trouvé"}")

    // f. Suppression d'un joueur
    val joueurASupprimer = Joueur("Ahmed", 12, 20)
    val suppressionResult = equipe1.suppression(joueurASupprimer)
    println("Suppression d'Ahmed de OCS : ${if (suppressionResult) "Succès" else "Échec"}")
    equipe1.affichage()

    // g. Mise à jour d'un joueur
    val nouveauJoueur = Joueur("Sara", 9, 25)
    val miseAJourResult = equipe1.miseAJour("Sara", nouveauJoueur)
    println("Mise à jour de Sara dans OCS : ${if (miseAJourResult) "Succès" else "Échec"}")
    equipe1.affichage()
}