package com.example.mykotlinapp.TestK.collections

class Cookie4(
    val name :String,
    val softBaked :Boolean,
    val hasFilling : Boolean,
    val price : Double

)

val cookie4 = listOf(
    Cookie4(
        name ="Chocolate Chip",
        softBaked =  false,
        hasFilling = false,
        price = 1.69

    ),

    Cookie4(
        name ="Banana Walunt",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),

    Cookie4
        (
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price =1.59
    ),
    Cookie4(
        name = "Chocolat Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie4(
        name = "Snickerdooble",
        softBaked = true,
        hasFilling = false,
        price = 1.79

    ),
    Cookie4(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie4(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main(){
    val groupedMenu=cookies.groupBy{it.softBaked}

    val softBakedMenu= groupedMenu[true]?:listOf()
    val crunchyMenu= groupedMenu[false]?:listOf()

    println("Soft cookies:")
    softBakedMenu.forEach {
        println("${it.name}-$${it.price}")
    }
    println("Crunchy cookies:")
    crunchyMenu.forEach {
        println("${it.name}-$${it.price}")
    }

}
