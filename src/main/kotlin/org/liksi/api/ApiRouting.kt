package org.liksi.api

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.liksi.api.model.Beer
import kotlin.uuid.Uuid

fun Application.configureApiRouting() {

    routing {
        route("/api") {
            route("/beers") {
                get {
                    call.respond(BeerService.getAllBeers())
                }

                get("/{id}") {
                    val id = call.parameters["id"]?.let { Uuid.parse(it) }

                    if (id == null) {
                        call.respond(HttpStatusCode.BadRequest, mapOf("error" to "ID invalide"))
                        return@get
                    }

                    val beer = BeerService.getBeerById(id)
                    if (beer != null) {
                        call.respond(beer)
                    } else {
                        call.respond(HttpStatusCode.NotFound, mapOf("error" to "Bière non trouvée"))
                    }
                }
                post {
                    val beer = call.receive<Beer>()
                    val createdBeer = BeerService.addBeer(beer)
                    call.respond(HttpStatusCode.Created, createdBeer)
                }
            }
        }
    }
}