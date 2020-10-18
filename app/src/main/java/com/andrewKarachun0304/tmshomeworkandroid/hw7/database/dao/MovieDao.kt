package com.andrewKarachun0304.tmshomeworkandroid.hw7.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.andrewKarachun0304.tmshomeworkandroid.hw7.database.entity.Movie

@Dao
interface MovieDao {
    @Insert
    suspend fun addMovie(movie: Movie)

    @Query("SELECT * FROM movie_table")
    suspend fun getAllMovie(): List<Movie>

    @Query("SELECT * FROM movie_table WHERE movie_name LIKE :name")
    suspend fun getMovieByName(name: String): List<Movie>
}