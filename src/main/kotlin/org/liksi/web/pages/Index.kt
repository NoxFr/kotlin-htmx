package org.liksi.web.pages

import beerListComponent
import kotlinx.html.*
import org.liksi.web.components.headerComponent
import org.liksi.web.components.beerCreationForm

fun HTML.index() {
    head {
        title { +"Kotlin with HTMX" }
        script(src = "/webjars/htmx.org/2.0.4/dist/htmx.min.js") {}
        script(src = "https://cdn.tailwindcss.com") {}
    }
    body {
        classes = setOf("bg-gray-100 flex items-center justify-center min-h-screen")
        div {
            classes = setOf("container mx-auto p-4")
            headerComponent()
            div {
                id = "beer-detail"
            }
            beerCreationForm()
            br()
            beerListComponent()
        }
    }
}