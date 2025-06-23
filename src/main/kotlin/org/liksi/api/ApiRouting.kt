package org.liksi.api

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.liksi.api.model.Beer

val beerService: BeerService = BeerService()

fun Application.configureApiRouting() {
    install(ContentNegotiation) {
        json()
    }

    routing {
        route("/api") {
            route("/beers") {
                get {
                    call.respond(beerService.getAllBeers())
                }

                get("/{id}") {
                    val id = call.parameters["id"]?.toIntOrNull()

                    if (id == null) {
                        call.respond(HttpStatusCode.BadRequest, mapOf("error" to "ID invalide"))
                        return@get
                    }

                    val beer = beerService.getBeerById(id)
                    if (beer != null) {
                        call.respond(beer)
                    } else {
                        call.respond(HttpStatusCode.NotFound, mapOf("error" to "Bière non trouvée"))
                    }
                }
                post {
                    val beer = call.receive<Beer>()
                    val createdBeer = beerService.addBeer(beer)
                    call.respond(HttpStatusCode.Created, createdBeer)
                }
            }
        }
    }
}