package org.liksi.web.components

import kotlinx.html.*
import org.liksi.api.Beer

fun LI.beerItemComponent(beer: Beer) {
    div {
        classes = setOf("font-medium")
        +"${beer.name} "
        span {
            classes = setOf("text-gray-500 text-sm")
            +"(${beer.abv}%)"
        }
    }
    div {
        classes = setOf("text-sm text-gray-600")
        +"Style: ${beer.style} | Brasserie: ${beer.brewery}"
    }
} 