package com.andrewKarachun0304.tmshomeworkandroid.hw7.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andrewKarachun0304.tmshomeworkandroid.hw7.database.dao.MovieDao
import com.andrewKarachun0304.tmshomeworkandroid.hw7.database.entity.Movie

@Database(entities = [Movie::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao

    companion object {
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase? {
            if (INSTANCE == null) {
                synchronized(AppDataBase::class) {
                    INSTANCE =
                        Room.databaseBuilder(context, AppDataBase::class.java, "movie_db").build()
                }
            }
            return INSTANCE
        }
    }
}