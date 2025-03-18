package org.liksi.web.pages

import kotlinx.html.*
import org.liksi.api.BeerService
import org.liksi.web.components.HEADER
import org.liksi.web.components.beerListComponent

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
            headerComponent()
            beerListComponent(beerService)
        }
    }
}

fun HEADER.headerComponent() {
    h1 {
        classes = setOf("text-4xl font-bold text-center text-blue-600 mb-6")
        +"My wonderful application"
    }
}