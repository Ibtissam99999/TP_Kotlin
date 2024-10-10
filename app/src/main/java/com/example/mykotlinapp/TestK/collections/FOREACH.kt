package com.example.mykotlinapp.TestK.collections

class Cookie(
    val name :String,
    val softBaked :Boolean,
    val hasFilling : Boolean,
    val price : Double

)

val cookies = listOf(
    Cookie(
        name ="Chocolate Chip",
        softBaked =  false,
        hasFilling = false,
        price = 1.69

    ),

    Cookie(
        name ="Banana Walunt",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),

    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price =1.59
    ),
    Cookie(
        name = "Chocolat Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdooble",
        softBaked = true,
        hasFilling = false,
        price = 1.79

        ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main(){
  cookies.forEach {
//      println("Menu item :$it")
//      println("Menu item :$it .name")
      println("Menu item :${it .name}")

  }
}