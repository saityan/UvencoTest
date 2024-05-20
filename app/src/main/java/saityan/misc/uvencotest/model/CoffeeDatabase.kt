package saityan.misc.uvencotest.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CoffeeCup::class], version = 1)
abstract class CoffeeDatabase : RoomDatabase() {

    abstract fun coffeeCupDao(): CoffeeCupDao
}