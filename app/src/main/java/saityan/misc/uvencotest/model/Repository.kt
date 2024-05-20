package saityan.misc.uvencotest.model

import javax.inject.Inject

class Repository @Inject constructor(
    private val coffeeDatabase: CoffeeDatabase
) {
    fun getAllCups(): List<CoffeeCup> {
        return coffeeDatabase.coffeeCupDao().getAllCups()
    }

    suspend fun getCupById(id: String): CoffeeCup {
        return coffeeDatabase.coffeeCupDao().getCupById(id)
    }

    suspend fun addCup(cup: CoffeeCup) {
        coffeeDatabase.coffeeCupDao().addCup(cup)
    }
}