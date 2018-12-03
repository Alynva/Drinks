package com.alynva.drinks.drinks.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.alynva.drinks.drinks.entities.Drink

@Database(entities = [(Drink::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private val DB_NAME = "drink.db"
        private var instance: AppDatabase? = null

        private fun create(context: Context): AppDatabase? {
            return Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DB_NAME).build()
        }

        fun getInstance(context: Context): AppDatabase {
            if (instance == null)
                instance = create(context)
            return instance!!
        }

    }

    abstract fun drinkDao(): DrinkDao

}