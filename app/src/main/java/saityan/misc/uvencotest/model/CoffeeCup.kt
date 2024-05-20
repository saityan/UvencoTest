package saityan.misc.uvencotest.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import saityan.misc.uvencotest.util.Constants.COFFEE_CUPS_TABLE

@Entity(tableName = COFFEE_CUPS_TABLE)
data class CoffeeCup(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String,
    val price: String,
    val isFree: Boolean,
    val cupVariant: CupVariant
)