package com.ramiro.krogerbenchlc.data.model


import com.google.gson.annotations.SerializedName

data class Weightmodel(
    @SerializedName("imperial")
    val imperial: String? = "",
    @SerializedName("metric")
    val metric: String? = ""
)