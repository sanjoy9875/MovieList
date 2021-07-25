package com.example.movieapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MoviesModel(

	@field:SerializedName("score")
	val score: Any? = null,

	@field:SerializedName("show")
	val show: ShowModel? = null
)