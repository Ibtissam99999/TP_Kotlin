package com.example.mykotlinapp.TestK



fun main(){
    var age =22
    var name : String ?="Ibtissam"

    println("votre nom est :$name et votre age est :$age")
//    println(name?.length)
//    if (name !=null){
//       println(name.length)
//    }

//    println(name!!.length)
// when(age){
//     5-> println("petit")
//     22-> println("grand")
//     else-> println("age non trouver")
// }

    when(age){
        in 0 .. 17-> println("mineure")

     else-> println("majore")}
    fun genre (name:String):String{
        if (name == "Ibtissam")
           return "une fille"
        else
            return "un garcons"
        return "erreur"
    }
    println(genre(name!!))
    val ages= Array<Int>  (10) {0 }
    println(ages[2])
    println(ages.contentToString())
    val tab= arrayOf(12,34,22,89,3,1)

    tab.set(2,9)
    tab[4]=0
    println(tab.contentToString())
    tab.toMutableList()


}



