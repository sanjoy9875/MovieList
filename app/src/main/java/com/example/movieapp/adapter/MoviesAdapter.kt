package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.model.MoviesModel

class MoviesAdapter(private val movies : List<MoviesModel>) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.support_simple_spinner_dropdown_item, parent, false)
        return MoviesViewHolder(view)
    }
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
//        holder.mTvName.text = tasks[position].name
//        holder.mTvAge.text = tasks[position].age.toString()
//        holder.mTvCount.text = tasks[position].count.toString()

    }
    override fun getItemCount(): Int {
        return movies.size
    }
    class MoviesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
//        val mTvName: TextView = view.findViewById<TextView>(R.id.tvName)
//        val mTvAge: TextView = view.findViewById<TextView>(R.id.tvAge)
//        val mTvCount: TextView = view.findViewById<TextView>(R.id.tvCount)


    }
}