package com.example.movieapp.remote

import com.example.movieapp.model.MoviesModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface APIService {

    @Headers("Accept: application/json")
    @GET("/search/shows?q=god")
    suspend fun getMovies(
        @Header("Content-Type") contentType: String,
    ): List<MoviesModel>

}