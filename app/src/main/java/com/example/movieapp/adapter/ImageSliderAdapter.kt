package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.model.MoviesModel
import com.makeramen.roundedimageview.RoundedImageView

class ImageSliderAdapter(private val movies : List<MoviesModel>,private val viewPager2: ViewPager2) :
    RecyclerView.Adapter<ImageSliderAdapter.SliderViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.slider_item_layout, parent, false)
        return ImageSliderAdapter.SliderViewHolder(view)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        Glide.with(holder.view)
            .load(movies[position].show?.image?.original)
            .into(holder.mIvImageSlide)
    }

    override fun getItemCount(): Int {
        return movies.size
    }


    class SliderViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val mIvImageSlide: RoundedImageView = view.findViewById(R.id.imageSlide)

    }

}