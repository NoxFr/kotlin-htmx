package org.liksi.web

import beerListComponent
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.div
import org.liksi.api.BeerService
import org.liksi.api.model.Beer
import org.liksi.web.components.beerDetailDialog
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
            val receiveParameters = call.receiveParameters()
            val beerName = receiveParameters["beerName"] ?: return@post call.respondText(
                "Missing beer name",
                status = HttpStatusCode.BadRequest
            )
            val beerStyle = receiveParameters["beerStyle"] ?: return@post call.respondText(
                "Missing beer type",
                status = HttpStatusCode.BadRequest
            )
            val abv = receiveParameters["abv"]?.toDoubleOrNull() ?: return@post call.respondText(
                "Invalid ABV",
                status = HttpStatusCode.BadRequest
            )
            val brewery = receiveParameters["brewery"] ?: return@post call.respondText(
                "Missing brewery",
                status = HttpStatusCode.BadRequest
            )

            BeerService.addBeer(
                Beer(
                    id = 0, // ID will be generated in the service
                    style = beerStyle,
                    name = beerName,
                    abv = abv,
                    brewery = brewery
                )
            )
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

