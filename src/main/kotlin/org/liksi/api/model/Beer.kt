package org.liksi.api.model

import kotlinx.serialization.Serializable
import kotlin.uuid.Uuid

@Serializable
data class Beer (
    val id: Uuid,
    val name: String,
    val style: String,
    val abv: Double,
    val brewery: String
)