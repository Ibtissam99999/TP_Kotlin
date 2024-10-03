package com.example.mykotlinapp.TP1

class CompteBancaire(val titulaire: String, var solde: Double) {

    fun depot(montant: Double) {
        if (montant > 0) {
            solde += montant
            println("Dépôt de $montant DH effectué. Nouveau solde: $solde DH")
        } else {
            println("Le montant du dépôt doit être supérieur à 0.")
        }
    }

    fun retrait(montant: Double) {
        if (montant > 0 && solde >= montant) {
            solde -= montant
            println("Retrait de $montant DH effectué. Nouveau solde: $solde DH")
        } else if (montant > solde) {
            println("Solde insuffisant pour retirer $montant DH. Solde actuel: $solde DH")
        } else {
            println("Le montant du retrait doit être supérieur à 0.")
        }
    }

    fun afficherSolde() {
        println("Le solde actuel du compte de $titulaire est: $solde DH")
    }
}

fun main() {
    val compte1 = CompteBancaire("Titulaire1", 1000.0)


    compte1.afficherSolde()


    compte1.depot(500.0)
    compte1.retrait(200.0)
    compte1.afficherSolde()

    compte1.retrait(1500.0)
    compte1.depot(-100.0)
    compte1.afficherSolde()
}
