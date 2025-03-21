package org.liksi.web.components

import kotlinx.html.*
import org.liksi.api.model.Beer

fun UL.beerItemComponent(beer: Beer) {
    li {                   
        classes = setOf("border-b-2 border-yellow-300 pb-4 cursor-grab hover:bg-yellow-100 flex items-center")
        attributes["hx-get"] = "/beer/${beer.id}"
        attributes["hx-target"] = "#beer-detail"
        div {
            classes = setOf("mr-5 text-yellow-600 flex-shrink-0")
            attributes["title"] = "Drag to reorder"
            +"⠿"
        }
        div {
            classes = setOf("flex-grow")
            div {
                classes = setOf("font-semibold text-yellow-900")
                input { type = InputType.hidden; name = "beerId"; value = beer.id.toString() }
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
} 