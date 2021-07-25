package com.example.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapp.model.MoviesModel
import com.example.movieapp.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers

class MoviesViewModel() : ViewModel() {

    val repository = MoviesRepository()

    fun getMovies() : LiveData<List<MoviesModel>>{

        return liveData(Dispatchers.IO){
            val data = repository.getMovies()

            emit(data.data!!)
        }

    }

}