package com.example.movieapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.movieapp.R
import com.example.movieapp.adapter.ImageSliderAdapter
import com.example.movieapp.adapter.MoviesAdapter
import com.example.movieapp.model.MoviesModel
import com.example.movieapp.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs

class MainActivity : AppCompatActivity(),OnClickListener{

    private val sliderList = mutableListOf<MoviesModel>()
    private val moviesList = mutableListOf<MoviesModel>()
    private lateinit var adapter : MoviesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       setSupportActionBar(toolBar)
        progressBar.visibility = View.VISIBLE

        recyclerView.layoutManager = GridLayoutManager(this,3)
        adapter = MoviesAdapter(moviesList,this)
        recyclerView.adapter = adapter

        val viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)


        viewModel.getMovies().observe(this, Observer {
            progressBar.visibility = View.GONE
            sliderList.addAll(it)
            moviesSlider()

            moviesList.clear()
            moviesList.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }


    private fun moviesSlider(){
        viewPagerImageSlider.adapter = ImageSliderAdapter(sliderList,viewPagerImageSlider)
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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onItemClicked(position: Int) {

        val intent = Intent(this,MovieDetailsActivity::class.java)
        intent.putExtra("movieImage",moviesList[position].show?.image?.medium)
        intent.putExtra("movieName",moviesList[position].show?.name)
        intent.putExtra("type",moviesList[position].show?.type)
        intent.putExtra("duration",moviesList[position].show?.runtime)
        intent.putExtra("premiered",moviesList[position].show?.premiered)


        intent.putExtra("ratings", moviesList[position].show?.rating?.average.toString())
        intent.putExtra("imdb", moviesList[position].show?.externals?.imdb)
        intent.putExtra("summary", moviesList[position].show?.summary)

        startActivity(intent)

    }
}