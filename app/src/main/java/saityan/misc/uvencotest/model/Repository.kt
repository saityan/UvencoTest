package saityan.misc.uvencotest.model

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val coffeeDatabase: CoffeeDatabase
) {
    fun getAllCups(): Flow<List<CoffeeCup>> {
        return coffeeDatabase.coffeeCupDao().getAllCups()
    }

    suspend fun getCupById(id: Int): CoffeeCup {
        return coffeeDatabase.coffeeCupDao().getCupById(id)
    }

    suspend fun addCup(cup: CoffeeCup) {
        coffeeDatabase.coffeeCupDao().addCup(cup)
    }
}