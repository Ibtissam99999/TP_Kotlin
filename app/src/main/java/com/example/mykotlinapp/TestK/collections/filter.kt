package com.example.mykotlinapp.TestK.collections

class Cookiees(
    val name :String,
    val softBaked :Boolean,
    val hasFilling : Boolean,
    val price : Double

)

val cookie = listOf(
    Cookiee(
        name ="Chocolate Chip",
        softBaked =  false,
        hasFilling = false,
        price = 1.69

    ),

    Cookiees(
        name ="Banana Walunt",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),

    Cookiees
        (
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price =1.59
    ),
    Cookiee(
        name = "Chocolat Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookiees(
        name = "Snickerdooble",
        softBaked = true,
        hasFilling = false,
        price = 1.79

    ),
    Cookiees(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookiees(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main(){
    val softBakedMenu = cookies.filter {
        it.softBaked
    }

    println("Soft cookies:")
    softBakedMenu.forEach {
        println("${it.name}-$${it.price}")
    }

}