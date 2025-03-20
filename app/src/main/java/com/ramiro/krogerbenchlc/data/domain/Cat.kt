package com.ramiro.krogerbenchlc.data.domain

import com.ramiro.krogerbenchlc.data.model.Weightmodel

data class Cat(
    val id: String,
    val url: String,
    val breeds: List<Breeds>
)

data class Breeds(
    val temperament: String? = "",
    val rare: Int? = 0,
    val referenceImageId: String? = "",
    val weight: Weight? = Weight(),
)

data class Weight(
    val imperial: String? = "",
    val metric: String? = ""
)