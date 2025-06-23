package org.liksi.api.model

import kotlinx.serialization.Serializable

@Serializable
data class Beer(
    val id: Int,
    val name: String,
    val style: String,
    val abv: Double,
    val brewery: String
)