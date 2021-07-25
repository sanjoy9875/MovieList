package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.movieapp.adapter.ImageSliderAdapter
import com.example.movieapp.model.MoviesModel
import com.example.movieapp.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private val moviesList = mutableListOf<MoviesModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        val viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)

        viewModel.getMovies().observe(this, Observer {
            moviesList.addAll(it)
            viewPagerImageSlider.adapter = ImageSliderAdapter(moviesList,viewPagerImageSlider)
            viewPagerImageSlider.clipToPadding = false
            viewPagerImageSlider.clipChildren = false
            viewPagerImageSlider.offscreenPageLimit = 3
            viewPagerImageSlider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

            val compositePageTransformer = CompositePageTransformer()
            compositePageTransformer.addTransformer(MarginPageTransformer(40))
            compositePageTransformer.addTransformer { page, position ->
                var r = 1 - abs(position)
                page.scaleY = 0.85f + r * 0.15f
            }
            viewPagerImageSlider.setPageTransformer(compositePageTransformer)
        })



    }
}