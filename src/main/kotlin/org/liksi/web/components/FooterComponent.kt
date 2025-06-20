package org.liksi.web.components

import kotlinx.html.*

fun FlowContent.footerComponent() {
    div {
        classes = setOf("mt-8 pt-4 border-t border-yellow-500 text-center")
        p {
            classes = setOf("text-gray-600 text-sm")
            +"© ${java.time.Year.now().value} Brewery App • Made with Kotlin and HTMX"
        }
    }
} 