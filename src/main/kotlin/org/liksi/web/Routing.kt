package org.liksi.web

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import org.liksi.web.pages.index

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondHtml {
                index()
            }
        }
    }
}

