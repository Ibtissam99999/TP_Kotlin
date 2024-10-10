package com.example.mykotlinapp.TP4

import com.example.mykotlinapp.TestK.collections.cookie5
import com.example.mykotlinapp.TestK.collections.cookies


data class Livre(
    val titre: String,
    val auteur: String,
    val anneePublication: Int,
    val genre: String,
    val nombrePages: Int,
    val note: Double
)
// Liste de livres pour l'exercice
val bibliotheque = listOf(
    Livre("1984", "George Orwell", 1949, "Science-fiction", 328, 4.5),
    Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943, "Conte", 96,
        4.8),
    Livre("Harry Potter à l'école des sorciers", "J.K. Rowling", 1997,
        "Fantasy", 309, 4.7),
    Livre("Orgueil et Préjugés", "Jane Austen", 1813, "Roman", 432, 4.6),
    Livre("Le Seigneur des Anneaux", "J.R.R. Tolkien", 1954, "Fantasy", 1178,
        4.9),
    Livre("Crime et Châtiment", "Fiodor Dostoïevski", 1866, "Roman", 671, 4.3),
    Livre("Fondation", "Isaac Asimov", 1951, "Science-fiction", 255, 4.4),
    Livre("Cent ans de solitude", "Gabriel García Márquez", 1967, "Réalisme magique", 417, 4.2)
    )
    fun main() {
//1)-
        bibliotheque.forEach {
            println("le titre du livre est:${it.titre}  et l'auteur est ${it.auteur}")
        }
// 2)-
        val list = bibliotheque.map {
            "${it.titre}"
        }
        println("la liste des titre :")
        list.forEach {
            println(it)
        }
//3)-
        val annespub = bibliotheque.filter {
            it.anneePublication>1950
        }
        println("les livre qui ent publier apres 1950 sont : ")
        println( annespub)
//4)-
        val groupLivre = bibliotheque.groupBy { it.genre }
        println("les livre groupe par genre")
        println(groupLivre)
//5)-
        val totalpage = bibliotheque.fold(0.0){ total, bibliotheque ->total +bibliotheque.nombrePages}
        println("Total price :${totalpage}$")
//6)-
        val anneePublication= bibliotheque.sortedBy {
            it.anneePublication
        }
        println("es livres par année de publication, du plus ancien au plus récent")
        println(anneePublication)
//7)-
        val listt= bibliotheque.filter { it.note>4.5 }.map { it.titre }.sortedBy { it }
        println("lesivre en oredre alphabetique et aves une note superieure de 4.5")
        println(listt)
//8)-
//        val decennies = bibliotheque.groupBy { (it.anneePublication/10)*10 }.mapValues { entry ->entry.value.map { it.titre }  }
//        println("le dictionner des livre groupe par decennies est")
//        println(decennies)

        val decennies = bibliotheque.groupBy { (it.anneePublication / 10) * 10 }
        println("Le dictionnaire des livres groupé par décennies est :")
        decennies.forEach { (decennie, livres) ->
            println("Décennie $decennie : ${livres.map { it.titre }}")
        }
    }

