package org.liksi.web.components

import kotlinx.html.*
import org.liksi.api.BeerService

fun DIV.beerListComponent(beerService: BeerService) {
    div {
        classes = setOf("bg-white shadow-md rounded-lg p-6")
        h2 {
            classes = setOf("text-2xl font-semibold text-gray-800 mb-4")
            +"Liste des bières"
        }

        ul {
            classes = setOf("space-y-2")
            beerService.getAllBeers().forEach { beer ->
                li {
                    classes = setOf("border-b pb-2")
                    beerItemComponent(beer)
                }
            }
        }
    }
} 