package routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import models.Mensaje
import models.mensajeStorage

fun Route.customerRouting() {
    route("/mensaje") {
        get {
            if (mensajeStorage.isNotEmpty()) {
                call.respond(mensajeStorage)
            } else {
                call.respondText("No se han encontrado mensajes", status = HttpStatusCode.OK)
            }
        }
        post {
            val mensaje = call.receive<Mensaje>()
            mensajeStorage.add(mensaje)
            call.respondText("El mensaje se ha guardado corectamente", status = HttpStatusCode.Created)
        }
    }
}