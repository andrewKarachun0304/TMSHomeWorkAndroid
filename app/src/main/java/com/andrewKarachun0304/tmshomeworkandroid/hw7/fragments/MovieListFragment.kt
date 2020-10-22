package com.andrewKarachun0304.tmshomeworkandroid.hw7.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrewKarachun0304.tmshomeworkandroid.R
import com.andrewKarachun0304.tmshomeworkandroid.hw7.MovieAdapter
import com.andrewKarachun0304.tmshomeworkandroid.hw7.database.AppDataBase
import com.andrewKarachun0304.tmshomeworkandroid.hw7.utils.launchForResult
import com.andrewKarachun0304.tmshomeworkandroid.hw7.utils.launchIO
import com.andrewKarachun0304.tmshomeworkandroid.hw7.utils.launchUI
import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListFragment : Fragment() {
    private val movieAdapter by lazy { MovieAdapter() }
    private val movieDao by lazy {
        AppDataBase.getInstance(requireContext().applicationContext)?.getMovieDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        movie_recycler_view.layoutManager = LinearLayoutManager(view?.context)
        movie_recycler_view.adapter = movieAdapter
        updateMovieList(search_movie_by_name_et.text.toString())

        add_movie_fab.setOnClickListener {
            findNavController().navigate(R.id.add_movie_frag_action)
        }

        search_movie_by_name_et.addTextChangedListener {
            updateMovieList(it.toString())
        }
    }

    private fun updateMovieList(name: String) {
        launchIO {
            launchForResult {
                val result = movieDao?.getMovieByName("${name.toString()}%")
                launchUI {
                    movieAdapter.updateMovieList(result)
                }
            }
        }
    }
}