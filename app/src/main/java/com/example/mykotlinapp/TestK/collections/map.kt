package com.example.mykotlinapp.TestK.collections

class Cookiee(
    val name :String,
    val softBaked :Boolean,
    val hasFilling : Boolean,
    val price : Double

)

val cookiess = listOf(
    Cookiee(
        name ="Chocolate Chip",
        softBaked =  false,
        hasFilling = false,
        price = 1.69

    ),

    Cookiee(
        name ="Banana Walunt",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),

    Cookiee(
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
    Cookiee(
        name = "Snickerdooble",
        softBaked = true,
        hasFilling = false,
        price = 1.79

    ),
    Cookiee(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookiee(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main(){
val fullMenu = cookiess.map{
"${it.name} - $${it.price}"
}
    println("Full menu:")
    fullMenu.forEach {
        println(it)
    }

}