package com.example.mykotlinapp.TestK

//class pers (var Name:String ,Year:Int){
//    constructor( Name: String):this( Name,2015)
//    constructor():this("Ibtissam")
//    init {
//        var thisyear = Calendar.getInstance().get(Calendar.YEAR)
//        var Age = thisyear-Year
//        println("votre nom est ${Name}et votre age est ${Age}")
//    }
////fun Afficher(){
//////    println("votre no est ${Name} et votre age est ${Age}")
////
////}
//
//}
//fun main(){
//    var P1=pers("Pers1",2002)
//    var P2=pers("pers2")
//    var P3=pers()
////    P1.Afficher()
////    P2.Afficher()
////    P3.Afficher()
//}


//declaration d'une data classe pour representer un etudiant
data class Etudiants (val nom:String ,val age:Int ,val moyenne:Double )

fun main(){
//     creation de plusieurs object Etudiant
    val etudiant1= Etudiants("Ahmed",20,15.5)
    val etudiant2= Etudiants("Sara",22,17.0)
    val etudiant3= Etudiants("Ahmed",20,15.5)
//    utilisation de toSting ()
    println(etudiant1)

    println(etudiant1==etudiant3)

    val etudiant4 =etudiant1.copy(nom = "Yassine")
    println(etudiant4)

    println("${etudiant2.nom} a une moyenne de ${etudiant2.moyenne}")

    val listeEtudiant= listOf(etudiant1,etudiant2,etudiant4)
    listeEtudiant.forEach { etudiant -> println("${etudiant.nom},Age :${etudiant.age},Moyenne :${etudiant.moyenne}")
    }
}