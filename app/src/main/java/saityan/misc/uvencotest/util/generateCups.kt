package saityan.misc.uvencotest.util

import saityan.misc.uvencotest.model.CoffeeCup
import saityan.misc.uvencotest.model.CupVariant

fun generateCups(): List<CoffeeCup> {
    val listOfNames = listOf("Амаретто", "Капучино", "Эспрессо", "Американо", "Фраппе", "Латте")

    val listOfCups: List<CoffeeCup> = mutableListOf<CoffeeCup>().apply {
        repeat(30) {
            val price = (100..199).random().toString()
            val isFree = it % 4 == 0

            val cup = CoffeeCup(
                name = listOfNames.random(),
                price = price,
                isFree = isFree,
                cupVariant = if (it % 3 == 0) CupVariant.NORMAL else CupVariant.CREAM
            )
            add(cup)
        }
    }

    return listOfCups
}