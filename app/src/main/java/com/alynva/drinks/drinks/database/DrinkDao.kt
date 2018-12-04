package com.alynva.drinks.drinks.database

import android.arch.persistence.room.*
import com.alynva.drinks.drinks.entities.Drink

@Dao
interface DrinkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(drink: Drink)

    @Query("SELECT * from drink")
    fun getAll(): List<Drink>

    @Query("SELECT COUNT() from drink LIMIT 1")
    fun hasSomething(): Int

//    @Update
//    fun update(drink: Drink)
//
//    @Delete
//    fun delete(drink: Drink)

    @Query("SELECT * from drink WHERE idDrink = :id")
    fun getDrink(id: Int): Drink
}