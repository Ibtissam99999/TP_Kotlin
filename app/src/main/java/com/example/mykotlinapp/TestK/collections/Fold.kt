package com.example.mykotlinapp.TestK.collections


class Cookie5(
    val name :String,
    val softBaked :Boolean,
    val hasFilling : Boolean,
    val price : Double

)

val cookie5 = listOf(
    Cookie5(
        name ="Chocolate Chip",
        softBaked =  false,
        hasFilling = false,
        price = 1.69

    ),

    Cookie5(
        name ="Banana Walunt",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),

    Cookie5
        (
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price =1.59
    ),
    Cookie5(
        name = "Chocolat Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie5(
        name = "Snickerdooble",
        softBaked = true,
        hasFilling = false,
        price = 1.79

    ),
    Cookie5(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie5(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main(){
    val totalPrice = cookie5.fold(0.0){total,cookie5 ->total +cookie5.price}
    println("Total price :${totalPrice}$")

}
