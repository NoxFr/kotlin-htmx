package org.liksi.web.components

import kotlinx.html.*
import org.liksi.api.model.Beer

fun FlowContent.beerDetailDialog(beer: Beer) {

    dialog {
        attributes["open"] = "true"
        id = "beer-detail-dialog"
        div {
            classes = setOf("fixed inset-0 bg-gray-600 bg-opacity-50")
        }
        div {
            classes = setOf("bg-yellow-50 shadow-lg rounded-lg p-8 border-t-4 border-yellow-500")
            style = "width: 500px; max-height: 80vh; overflow-y: auto; z-index: 10; position: relative;"
            h2 {
                classes = setOf("text-3xl font-bold text-yellow-800 mb-6 flex items-center")
                i(classes = "fas fa-beer mr-2") {}
                +beer.name
            }
            p {
                classes = setOf("text-yellow-700 mb-2")
                strong { +"ABV: " }
                +"${beer.abv}%"
            }
            p {
                classes = setOf("text-yellow-700 mb-2")
                strong { +"Style: " }
                +beer.style
            }
            p {
                classes = setOf("text-yellow-700 mb-4")
                strong { +"Brewery: " }
                +beer.brewery
            }
            form {
                attributes["method"] = "dialog"
                div {
                    classes = setOf("flex justify-end mt-4")
                    button {
                        classes = setOf("text-white bg-yellow-500 hover:bg-yellow-600 rounded px-4 py-2")
                        +"Close"
                    }
                }
            }
        }
    }
}
