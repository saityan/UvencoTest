package saityan.misc.uvencotest.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CoffeeCupDao {

    @Query("SELECT * FROM coffee_cups_table")
    fun getAllCups(): List<CoffeeCup>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCup(): CoffeeCup
}