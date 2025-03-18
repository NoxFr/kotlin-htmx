package org.liksi.web.pages

import beerListComponent
import kotlinx.html.*
import org.liksi.web.components.headerComponent

fun HTML.index() {
    head {
        title { +"Kotlin with HTMX" }
        script(src = "https://unpkg.com/htmx.org@1.9.12") {}
        script(src = "https://cdn.tailwindcss.com") {}
    }
    body {
        classes = setOf("bg-gray-100 flex items-center justify-center min-h-screen")
        div {
            classes = setOf("container mx-auto p-4")
            headerComponent()
            beerListComponent()
        }
    }
}