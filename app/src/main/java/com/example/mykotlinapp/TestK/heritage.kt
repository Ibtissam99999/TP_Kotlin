package com.example.mykotlinapp.TestK
open class perssone(var Cin:String,var Nom:String,var Age:Int){
    open fun afficher(){
        println("Mr/Ms ${Nom}  votre Cin est ${Cin} est votre Age est ${Age}")
    }
}

class Formateur( Cin: String,Nom: String,Age: Int,var Specialite:String,var Slaire:Int):
    perssone(Nom,Cin,Age){
  override fun afficher(){
    super.afficher()
    println("votre specialite est ${Specialite} est votre Salaire est ${Slaire}")


}}


fun main(){
     var P1 = perssone("HH12345","pes1",20)
    var F1= Formateur("HH23409","for1",22,"info",123)
    P1.afficher()
    F1.afficher()
}