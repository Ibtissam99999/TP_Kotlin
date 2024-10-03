open class Personne {
    var id: Int = 0
    var nom: String = ""
    var prenom: String = ""
    var age: Byte = 0


    constructor(id: Int, nom: String, prenom: String, age: Byte) {
        this.id = id
        this.nom = nom
        this.prenom = prenom
        this.age = age
    }

    open fun afficherInfos() {
        println("Nom : $nom")
        println("Prénom : $prenom")
        println("Âge : $age ans")
    }
}

class Employe : Personne {
    var salaire: Double = 0.0

    companion object {
        var nombreEmployes = 0
        fun getNombreEmployess():Int{
            return nombreEmployes
        }
    }
init {
    nombreEmployes++
}
    constructor(id: Int, nom: String, prenom: String, age: Byte, salaire: Double) : super(id, nom, prenom, age) {
        this.salaire = salaire


    }

    override fun afficherInfos() {
        super.afficherInfos()
        println("Salaire : $salaire DH")
        println("=======================================")
    }
}

fun main() {
    val employe1 = Employe(1, "Nom1", "Prenom1", 30, 3000.0)
    val employe2 = Employe(2, "Nom2", "Prenom2", 28, 3500.0)

    employe1.afficherInfos()
    employe2.afficherInfos()


    println("Nombre total d'employés : ${Employe.getNombreEmployess()}")
}
