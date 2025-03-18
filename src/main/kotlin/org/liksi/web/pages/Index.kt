package org.liksi.web.pages

import kotlinx.html.*
import org.liksi.api.BeerService

private val beerService = BeerService()

fun HTML.index() {
    head {
        title { +"Kotlin with HTMX" }
        script(src = "https://unpkg.com/htmx.org@2.0.4") {}
        script(src = "https://cdn.tailwindcss.com") {}
    }
    body {
        classes = setOf("bg-gray-100 flex items-center justify-center min-h-screen")
        div {
            classes = setOf("container mx-auto p-4")
            h1 {
                classes = setOf("text-4xl font-bold text-center text-blue-600 mb-6")
                +"My wonderful application"
            }
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
                    }
                }
            }
        }
    }
}