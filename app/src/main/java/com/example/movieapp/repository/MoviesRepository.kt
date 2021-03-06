package com.example.movieapp.repository

import com.example.movieapp.model.MoviesModel
import com.example.movieapp.remote.APIService
import com.example.movieapp.remote.Resource
import com.example.movieapp.remote.ResponseHandler
import com.example.movieapp.remote.RetrofitGenerator


class MoviesRepository()  {

    private val CONTENT_TYPE = "application/json"

    val api = RetrofitGenerator.getInstance()
        .create(APIService::class.java)

    val responseHandler = ResponseHandler()

    suspend fun getMovies() : Resource<List<MoviesModel>>{

        val result = api.getMovies(CONTENT_TYPE)
        return responseHandler.handleSuccess(result)
    }
}
