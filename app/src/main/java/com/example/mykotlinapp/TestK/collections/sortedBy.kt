package com.example.mykotlinapp.TestK.collections


class Cookie6(
    val name :String,
    val softBaked :Boolean,
    val hasFilling : Boolean,
    val price : Double

)

val cookie6 = listOf(
    Cookie6(
        name ="Chocolate Chip",
        softBaked =  false,
        hasFilling = false,
        price = 1.69

    ),

    Cookie6(
        name ="Banana Walunt",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),

    Cookie6
        (
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price =1.59
    ),
    Cookie6(
        name = "Chocolat Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie6(
        name = "Snickerdooble",
        softBaked = true,
        hasFilling = false,
        price = 1.79

    ),
    Cookie6(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie6(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main(){
    val alphabeticalMenu = cookie6.sortedBy {
        it.name
    }
    println("Alphabetical menu:")
    alphabeticalMenu.forEach {
        println(it.name)
    }
}

