package org.liksi.web.components

import kotlinx.html.*
import org.liksi.api.model.Beer

fun UL.beerItemComponent(beer: Beer) {
    li {
        classes = setOf("border-b-2 border-yellow-300 pb-4")
        div {
            classes = setOf("font-semibold text-yellow-900")
            +"${beer.name} "
            span {
                classes = setOf("text-yellow-600 text-sm")
                +"(${beer.abv}%)"
            }
        }
        div {
            classes = setOf("text-sm text-yellow-700 italic")
            +"Style: ${beer.style} | Brewery: ${beer.brewery}"
        }
    }
} 