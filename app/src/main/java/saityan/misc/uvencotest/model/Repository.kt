package saityan.misc.uvencotest.model

import androidx.room.withTransaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import saityan.misc.uvencotest.util.generateCups
import javax.inject.Inject

class Repository @Inject constructor(
    private val coffeeDatabase: CoffeeDatabase
) {
    fun getAllCups(): Flow<List<CoffeeCup>> = flow {
        if (getCupCount() == 0) {
            emitAll(insertMockDataAndReturnFlow())
        } else {
            emitAll(coffeeDatabase.coffeeCupDao().getAllCups())
        }
    }

    private suspend fun insertMockDataAndReturnFlow(): Flow<List<CoffeeCup>> {
        val mockData = generateCups()
        insertMockDataIntoDatabase(mockData)
        return coffeeDatabase.coffeeCupDao().getAllCups()
    }

    private suspend fun insertMockDataIntoDatabase(list: List<CoffeeCup>) {
        coffeeDatabase.withTransaction {
            list.forEach { cup ->
                coffeeDatabase.coffeeCupDao().addCup(cup)
            }
        }
    }

    suspend fun getCupById(id: Int): CoffeeCup {
        return coffeeDatabase.coffeeCupDao().getCupById(id)
    }

    suspend fun addCup(cup: CoffeeCup) {
        coffeeDatabase.coffeeCupDao().addCup(cup)
    }

    private suspend fun getCupCount(): Int {
        return coffeeDatabase.coffeeCupDao().getCupCount()
    }
}