package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import routes.*

fun Application.configureRouting() {
    routing {
        customerRouting()
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
