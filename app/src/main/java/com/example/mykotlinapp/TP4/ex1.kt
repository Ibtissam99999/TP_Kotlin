//package com.example.mykotlinapp.TP4
//
//// Classe Produit
//open class Produit {
//
//    var code: Int
//    var prixOrigine: Double
//
//
//    constructor(code: Int, prixOrigine: Double) {
//        this.code = code
//        this.prixOrigine = prixOrigine
//    }
//
//    constructor(code: Int) {
//        this.code = code
//        this.prixOrigine = 0.0
//    }
//
//
//    open fun prixProduit(): Double {
//        return prixOrigine
//    }
//
//
//    override fun toString(): String {
//        return "$code;$prixOrigine"
//    }
//
//
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (other !is Produit) return false
//        return this.code == other.code
//    }
//
//    override fun hashCode(): Int {
//        return code.hashCode()
//    }
//}
//// Classe ProduitEnSolde
//class ProduitEnSolde(code: Int, prixOrigine: Double, remise: Double) : Produit(code, prixOrigine) {
//    var remise: Double = remise
//        set(value) {
//            if (value in 0.0..90.0) {
//                field = value
//            } else {
//                throw IllegalArgumentException("La remise doit être comprise entre 0 et 90.")
//            }
//        }
//
//    init {
//        this.remise = remise
//    }
//
//    override fun prixProduit(): Double {
//        return prixOrigine * (1 - remise / 100)
//    }
//
//    override fun toString(): String {
//        return "${super.toString()};$remise"
//    }
//}
//// Classe Boutique
//class Boutique {
//    private val produits: MutableList<Produit> = mutableListOf()
//
//    fun indiceDe(code: Int): Int {
//
//        return produits.indexOfFirst { it.code == code }
//    }
//
//    fun ajouter(p: Produit) {
//        if (indiceDe(p.code) != -1) {
//            throw IllegalArgumentException("Le produit avec le code ${p.code} existe déjà dans la boutique.")
//        }
//        produits.add(p)
//    }
//
//    fun supprimer(code: Int): Boolean {
//        val index = indiceDe(code)
//        return if (index != -1) {
//            produits.removeAt(index)
//            true
//        } else {
//            false
//        }
//    }
//
//    fun supprimer(p: Produit): Boolean {
//        return produits.remove(p)
//    }
//
//    fun nombreProduitsEnSolde(): Int {
//        return produits.count { it is ProduitEnSolde }
//    }
//
//
//}
//fun main() {
//    val boutique = Boutique()
//
//    val produit1 = Produit(101, 50.0)
//    val produit2 = ProduitEnSolde(102, 100.0, 20.0)
//    val produit3 = ProduitEnSolde(103, 200.0, 15.0)
//
//    boutique.ajouter(produit1)
//    boutique.ajouter(produit2)
//    boutique.ajouter(produit3)
//
//    println("Liste des produits dans la boutique:")
//    println(boutique)
//
//    println("Nombre de produits en solde: ${boutique.nombreProduitsEnSolde()}")
//
//    val suppression = boutique.supprimer(101)
//    println("Produit avec le code 101 supprimé: $suppression")
//
//    println("Liste des produits après suppression:")
//    println(boutique)
//}
//
