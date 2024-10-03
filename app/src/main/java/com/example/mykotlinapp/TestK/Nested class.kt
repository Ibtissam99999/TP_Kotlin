class Universite(val name: String) {
    inner class Departement(val nom: String, val nbEtudiants: Int) {
        fun afficherDetails() {
            println("Département: $nom, Nombre d'étudiants: $nbEtudiants")
        }
    }

    fun afficherUniversite() {
        println("Université: $name")
    }
}

fun main() {
    val universite = Universite("Université de Safi")
    universite.afficherUniversite()

    // Création d'un département au sein de l'université
    val departement = universite.Departement("Informatique", 150)
    departement.afficherDetails()
}
