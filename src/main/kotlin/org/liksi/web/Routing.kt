package org.liksi.web

import beerListComponent
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.div
import org.liksi.api.BeerService
import org.liksi.web.components.beerDetailDialog
import org.liksi.web.model.CreateBeer
import org.liksi.web.pages.index

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
            val beer = requireNotNull(BeerService.getBeerById(id)) {
                "Beer not found"
            }
            call.respondHtml {
                body {
                    beerDetailDialog(beer)
                }
            }
        }
        post("/add-beer") {
            BeerService.addBeer(call.receive<CreateBeer>())
            call.respondHtml {
                body {
                    div {
                        beerListComponent()
                    }
                }
            }
        }
    }
}

