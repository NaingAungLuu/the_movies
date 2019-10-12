package com.androboy.themovies.data.vos

import com.google.gson.annotations.SerializedName
import java.util.*

data class DateVO(

    @SerializedName("maximum")
    val maximum : Date,

    @SerializedName("minimum")
    val minimum : Date

){
}