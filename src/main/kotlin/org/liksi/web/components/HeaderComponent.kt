package org.liksi.web.components

import kotlinx.html.FlowContent
import kotlinx.html.classes
import kotlinx.html.h1

fun FlowContent.headerComponent() {
    h1 {
        classes = setOf("text-4xl font-bold text-center text-blue-600 mb-6")
        +"My wonderful application"
    }
} 