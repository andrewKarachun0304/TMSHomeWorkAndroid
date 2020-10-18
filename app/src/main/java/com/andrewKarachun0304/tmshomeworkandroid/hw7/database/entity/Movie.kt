package com.andrewKarachun0304.tmshomeworkandroid.hw7.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movie_table")
class Movie(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "movie_name")
    val name: String,
    @ColumnInfo(name = "movie_year")
    val year: Int,
    @ColumnInfo(name = "movie_director")
    val director: String,
    @ColumnInfo(name = "movie_duration")
    val duration: Int,
    @ColumnInfo(name = "movie_image_url")
    val url: String
):Parcelable