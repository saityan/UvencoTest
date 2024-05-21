package saityan.misc.uvencotest.util

import saityan.misc.uvencotest.model.CoffeeCup
import saityan.misc.uvencotest.model.CupVariant

fun generateCups(): List<CoffeeCup> {
    val listOfCups: List<CoffeeCup> = mutableListOf<CoffeeCup>().apply {
        repeat(30) {
            val price = (100..199).random().toString()
            val isFree = it % 10 == 0

            val cup = CoffeeCup(
                name = "Coffee Cup ${it + 1}",
                price = price,
                isFree = isFree,
                cupVariant = CupVariant.CREAM
            )
            add(cup)
        }
    }

    return listOfCups
}