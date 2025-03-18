package org.liksi.web.components

import kotlinx.html.*
import org.liksi.api.model.BeerStyle

fun DIV.beerCreationForm() {
    div {
        classes = setOf("bg-yellow-50 shadow-lg rounded-lg p-8 border-t-4 border-yellow-500")
        h2 {
            classes = setOf("text-3xl font-bold text-yellow-800 mb-6 text-center")
            +"Create a New Beer"
        }
        p {
            classes = setOf("text-yellow-600 mb-6 text-center")
            +"Fill out the form below to add a new beer to the list."
        }
        form {
            classes = setOf("bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4")
            attributes["hx-post"] = "/add-beer"
            attributes["hx-target"] = "#beer-list"
            attributes["hx-swap"] = "outerHTML"
            div {
                classes = setOf("mb-4")
                label {
                    classes = setOf("block text-yellow-700 text-sm font-bold mb-2")
                    htmlFor = "beerName"
                    +"Beer Name"
                }
                input(type = InputType.text, name = "beerName") {
                    id = "beerName"
                    classes = setOf("shadow appearance-none border rounded w-full py-2 px-3 text-yellow-700 leading-tight focus:outline-none focus:shadow-outline")
                }
            }
            div {
                classes = setOf("mb-4")
                label {
                    classes = setOf("block text-yellow-700 text-sm font-bold mb-2")
                    htmlFor = "beerStyle"
                    +"Beer Style"
                }
                select {
                    id = "beerStyle"
                    name = "beerStyle"
                    classes = setOf("shadow appearance-none border rounded w-full py-2 px-3 text-yellow-700 leading-tight focus:outline-none focus:shadow-outline")
                    option { value = ""; +"Select a style" }
                    BeerStyle.entries.forEach { style ->
                        option { value = style.name; +style.displayName }
                    }
                }
            }
            div {
                classes = setOf("mb-4")
                label {
                    classes = setOf("block text-yellow-700 text-sm font-bold mb-2")
                    htmlFor = "abv"
                    +"ABV (%)"
                }
                input(type = InputType.number, name = "abv") {
                    id = "abv"
                    classes = setOf("shadow appearance-none border rounded w-full py-2 px-3 text-yellow-700 leading-tight focus:outline-none focus:shadow-outline")
                    step = "0.1"
                    min = "0"
                    max = "100"
                }
            }
            div {
                classes = setOf("mb-4")
                label {
                    classes = setOf("block text-yellow-700 text-sm font-bold mb-2")
                    htmlFor = "brewery"
                    +"Brewery"
                }
                input(type = InputType.text, name = "brewery") {
                    id = "brewery"
                    classes = setOf("shadow appearance-none border rounded w-full py-2 px-3 text-yellow-700 leading-tight focus:outline-none focus:shadow-outline")
                }
            }
            div {
                classes = setOf("flex items-center justify-between")
                button(type = ButtonType.submit) {
                    classes = setOf("bg-yellow-500 hover:bg-yellow-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline")
                    +"Create Beer"
                }
            }
        }
    }
}