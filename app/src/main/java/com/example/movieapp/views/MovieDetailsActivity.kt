package com.example.movieapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.bumptech.glide.Glide
import com.example.movieapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movie_details.*
import java.util.ArrayList

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        setSupportActionBar(movieDetailsToolBar)

        getDataFromIntentAndSetToViews()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.movie_details_menu,menu)
        return true
    }

    private fun getDataFromIntentAndSetToViews() {

        var genreList : ArrayList<String> = ArrayList<String>()

        val movieImage = intent.getStringExtra("movieImage")
        val movieName = intent.getStringExtra("movieName")
        val type = intent.getStringExtra("type")
        val duration = intent.getIntExtra("duration",0)
        val premiered = intent.getStringExtra("premiered")

        val ratings = intent.getStringExtra("ratings")
        val imdb = intent.getStringExtra("imdb")
        val summary = intent.getStringExtra("summary")

        Glide.with(applicationContext)
            .load(movieImage)
            .into(ivMovieImage)

        tvMovieName.text = movieName
        tvType.text = type
        tvTime.text = "$duration min"
        tvDate.text = premiered
        tvGenre1.text = ""
        tvGenre2.text = ""
        tvGenre3.text = ""
        tvImdb.text = imdb
        tvSummary.text = summary

    }
}