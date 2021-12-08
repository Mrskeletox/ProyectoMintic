package com.cubidevs.holaandroid


import com.google.gson.annotations.SerializedName

data class SuperheroeItem(
    @SerializedName("alias")
    val alias: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("facebook")
    val facebook: String