package org.liksi.web.pages

import kotlinx.html.*

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
            h1 {
                classes = setOf("text-4xl font-bold text-center text-blue-600 mb-6")
                +"My wonderful application"
            }
            div {
                classes = setOf("bg-white shadow-md rounded-lg p-6")
                h2 {
                    classes = setOf("text-2xl font-semibold text-gray-800 mb-4")
                    +"Un bloc de contenu"
                }

                ul {
                    for (n in 1..10) {
                        li { +"$n" }
                    }
                }
            }
        }
    }
}