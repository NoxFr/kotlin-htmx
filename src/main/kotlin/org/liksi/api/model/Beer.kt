package org.liksi.api.model

data class Beer(
    val id: Int,
    val name: String,
    val style: String,
    val abv: Double,
    val brewery: String
)