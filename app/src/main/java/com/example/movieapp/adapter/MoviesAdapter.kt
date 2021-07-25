package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.model.MoviesModel
import com.example.movieapp.views.OnClickListener

class MoviesAdapter(private val movies : List<MoviesModel>,private val onClickListener: OnClickListener) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movies_item_layout, parent, false)
        return MoviesViewHolder(view)
    }
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        Glide.with(holder.view)
            .load(movies[position].show?.image?.medium)
            .into(holder.mIvMovieImage)

        holder.itemView.setOnClickListener {
            onClickListener.onItemClicked(position)
        }

    }
    override fun getItemCount(): Int {
        return movies.size
    }
    class MoviesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val mIvMovieImage : ImageView = view.findViewById(R.id.ivMovie)

    }
}