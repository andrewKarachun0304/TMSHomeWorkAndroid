package com.andrewKarachun0304.tmshomeworkandroid.hw7

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andrewKarachun0304.tmshomeworkandroid.R
import com.andrewKarachun0304.tmshomeworkandroid.hw7.database.entity.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieVH>() {

    private var movieList = ArrayList<Movie>()

    fun updateMovieList(list: List<Movie>?) {
        movieList = list as ArrayList<Movie>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MovieVH(view)
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount() = movieList.size

    class MovieVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(movie: Movie) {
            with(itemView) {
                movie_name_tv.text = movie.name
                movie_director_tv.text = movie.director
                movie_year_tv.text = "${movie.year} год."
                movie_duration_tv.text = "${movie.duration} минут(ы)."
                Picasso.get().load(movie.url).into(movie_iv)
            }
        }
    }
}