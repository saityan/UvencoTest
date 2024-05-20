package saityan.misc.uvencotest.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CoffeeCupDao {

    @Query("SELECT * FROM coffee_cups_table")
    fun getAllCups(): Flow<List<CoffeeCup>>

    @Query("SELECT * FROM coffee_cups_table WHERE id = :id")
    fun getCupById(id: Int): Flow<CoffeeCup>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCup(cup: CoffeeCup)

    @Query("SELECT COUNT(*) FROM coffee_cups_table")
    suspend fun getCupCount(): Int
}