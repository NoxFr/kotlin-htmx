package org.liksi.web.model

import kotlinx.serialization.Serializable

@Serializable
data class CreateBeer(
    val beerName: String,
    val beerStyle: String,
    val abv: Double,
    val brewery: String
)