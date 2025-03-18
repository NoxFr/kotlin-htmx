package org.liksi.web

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import kotlinx.html.body
import org.liksi.api.BeerService
import org.liksi.web.components.beerDetailDialog
import org.liksi.web.pages.index

val beerService = BeerService()

fun Application.configureRouting() {
    routing {
        staticResources("/webjars", "/META-INF/resources/webjars")
        get("/") {
            call.respondHtml {
                index()
            }
        }
        get("/beer/{id}") {
            val id = requireNotNull(call.parameters["id"]?.toIntOrNull()) {
                "Invalid beer ID"
            }
            val beer = requireNotNull(beerService.getBeerById(id)) {
                "Beer not found"
            }
            call.respondHtml {
                body {
                    beerDetailDialog(beer)
                }
            }
        }
    }
}

