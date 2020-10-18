package com.andrewKarachun0304.tmshomeworkandroid.hw7.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.andrewKarachun0304.tmshomeworkandroid.R
import com.andrewKarachun0304.tmshomeworkandroid.hw7.database.AppDataBase
import com.andrewKarachun0304.tmshomeworkandroid.hw7.database.entity.Movie
import com.andrewKarachun0304.tmshomeworkandroid.hw7.entity.launchIO
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_add_movie.*

class AddMovieFragment : Fragment() {
    private val movieDao by lazy {
        AppDataBase.getInstance(requireContext().applicationContext)?.getMovieDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        load_image_btn.setOnClickListener {
            val url = image_url_et.text
            if (!url.isNullOrEmpty()) {
                Picasso.get().load("$url").into(movie_image_iv)
            }
        }

        save_movie_btn.setOnClickListener {
            addMovieToDb()
        }
    }

    private fun addMovieToDb() {
        val name = movie_name_et.text.toString()
        val url = image_url_et.text.toString()
        val director = movie_director_et.text.toString()
        val year = movie_year_et.text.toString().toInt()
        val duration = movie_duration_et.text.toString().toInt()

        if (name != "") {
            launchIO {
                movieDao?.addMovie(
                    Movie(
                        name = name,
                        url = url,
                        director = director,
                        year = year,
                        duration = duration
                    )
                )
            }
            findNavController().popBackStack()
        }
    }
}