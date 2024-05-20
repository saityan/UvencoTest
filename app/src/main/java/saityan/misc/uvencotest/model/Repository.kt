package saityan.misc.uvencotest.model

import javax.inject.Inject

class Repository @Inject constructor(
    private val coffeeDatabase: CoffeeDatabase
) {
    fun getAllCups(): List<CoffeeCup> {
        return coffeeDatabase.coffeeCupDao().getAllCups()
    }
}