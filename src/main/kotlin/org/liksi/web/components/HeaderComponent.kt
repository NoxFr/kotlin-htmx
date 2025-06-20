package org.liksi.web.components

import kotlinx.html.FlowContent
import kotlinx.html.classes
import kotlinx.html.h1

fun FlowContent.headerComponent() {
    h1 {
        classes = setOf("text-5xl font-extrabold text-center text-yellow-700 mb-8 border-b-4 border-yellow-500 pb-2")
        +"\uD83C\uDF7A Welcome to the Brewery"
    }
} 