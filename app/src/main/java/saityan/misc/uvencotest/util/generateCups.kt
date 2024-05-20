package saityan.misc.uvencotest.util

import saityan.misc.uvencotest.model.CoffeeCup
import saityan.misc.uvencotest.model.CupVariant

fun generateCups(): List<CoffeeCup> {
    val listOfCups: List<CoffeeCup> = mutableListOf<CoffeeCup>().apply {
        repeat(30) {
            val price = (10..100).random().toString() // Random price between 10 and 100
            val isFree = it % 10 == 0 // Mark every 10th cup as free

            val cup = CoffeeCup(
                name = "Coffee Cup $it",
                price = price,
                isFree = isFree,
                cupVariant = CupVariant.NORMAL
            )
            add(cup)
        }
    }

    return listOfCups
}