package com.ramiro.krogerbenchlc.data.model


import com.google.gson.annotations.SerializedName

data class CatsModelItemmodel(
    @SerializedName("breeds")
    val breeds: List<Breedmodel>? = listOf(),
    @SerializedName("height")
    val height: Int? = 0,
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("width")
    val width: Int? = 0
)