// Classe Produit
open class Produit {
    var code: Int
    var prixOrigine: Double

    constructor(code: Int, prixOrigine: Double) {
        this.code = code
        this.prixOrigine = prixOrigine
    }

    constructor(code: Int) {
        this.code = code
        this.prixOrigine = 0.0
    }

    open fun prixProduit(): Double {
        return prixOrigine
    }

    override fun toString(): String {
        return "$code;$prixOrigine"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        other as Produit
        return this.code == other.code
    }

//    override fun hashCode(): Int {
//        return code
//    }
}

// Classe ProduitEnSolde
class ProduitEnSolde : Produit {
    private var _remise: Int

    var remise: Int
        get() = _remise
        set(value) {
            if (value in 0..90) {
                _remise = value
            } else {
                throw IllegalArgumentException("La remise doit être comprise entre 0 et 90.")
            }
        }

    constructor(code: Int, prixOrigine: Double, remise: Int) : super(code, prixOrigine) {
        if (remise in 0..90) {
            this._remise = remise
        } else {
            throw IllegalArgumentException("La remise doit être comprise entre 0 et 90.")
        }
    }

    override fun prixProduit(): Double {
        return prixOrigine * (100 - remise) / 100.0
    }

    override fun toString(): String {
        return "${super.toString()};$remise"
    }
}

// Classe Boutique
class Boutique {
    private var produits: MutableList<Produit>

    constructor() {
        produits = mutableListOf()
    }

    fun indiceDe(code: Int): Int {
        var index = 0
        for (p in produits) {
            if (p.code == code) {
                return index
            }
            index += 1
        }
        return -1
    }

    fun ajouter(p: Produit) {
        if (indiceDe(p.code) != -1) {
            throw Exception("Le produit avec le code ${p.code} existe déjà dans la boutique.")
        }
        produits.add(p)
    }

    fun supprimer(code: Int): Boolean {
        val index = indiceDe(code)
        if (index != -1) {
            produits.removeAt(index)
            return true
        }
        return false
    }

    fun supprimer(p: Produit): Boolean {
        var index = 0
        for (prod in produits) {
            if (prod.equals(p)) {
                produits.removeAt(index)
                return true
            }
            index += 1
        }
        return false
    }

    fun nombreProduitsEnSolde(): Int {
        var count = 0
        for (p in produits) {
            if (p is ProduitEnSolde) {
                count += 1
            }
        }
        return count
    }

    fun afficherProduits() {
        for (p in produits) {
            println(p.toString())
        }
    }
}

fun main() {
    // Création de la boutique
    val boutique = Boutique()

    // Création de produits
    val produit1 = Produit(101, 50.0)
    val produit2 = ProduitEnSolde(102, 100.0, 20)
    val produit3 = ProduitEnSolde(103, 200.0, 15)

    // Ajout des produits à la boutique
    boutique.ajouter(produit1)
    boutique.ajouter(produit2)
    boutique.ajouter(produit3)

    // Affichage des produits
    println("Liste des produits dans la boutique:")
    boutique.afficherProduits()

//    verifications de l'egalite
    println("les produit 1 et 2 sont egaux?")
    println(produit1.equals(produit2))

    println("les produit 1 et 1 sont egaux?")
    println(produit1.equals(produit1))

    // Nombre de produits en solde
    println("Nombre de produits en solde: ${boutique.nombreProduitsEnSolde()}")

    // Suppression d'un produit par code
    val suppression = boutique.supprimer(101)
    println("Produit avec le code 101 supprimé: $suppression")

//    suppression d'un produit par produit

    val suppress = boutique.supprimer(produit3)
    println("Produit3 a ete suprimer:$suppress")

    // Affichage après suppression
    println("Liste des produits après suppression:")
    boutique.afficherProduits()
}