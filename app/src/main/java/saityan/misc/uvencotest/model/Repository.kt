package saityan.misc.uvencotest.model

import javax.inject.Inject

class Repository @Inject constructor(
    private val coffeeDatabase: CoffeeDatabase
) {
    fun getAllCups(): List<CoffeeCup> {
        return coffeeDatabase.coffeeCupDao().getAllCups()
    }

    fun getCupById(id: Int): CoffeeCup {
        return coffeeDatabase.coffeeCupDao().getCupById(id)
    }

    suspend fun addCup(cup: CoffeeCup) {
        coffeeDatabase.coffeeCupDao().addCup(cup)
    }
}