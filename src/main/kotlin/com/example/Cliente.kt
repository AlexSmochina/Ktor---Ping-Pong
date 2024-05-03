package com.example

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import models.Mensaje
import java.net.http.HttpClient
import java.net.http.HttpResponse
import java.util.Scanner


suspend fun main() {
    val client = HttpClient(CIO)
    val scan = Scanner(System.`in`)

    print("Escribe el mensaje: ")
    val message = Mensaje(scan.nextLine()).toString()

    var response: HttpResponse = client.post("http://127.0.0.1:8080/mensaje") {
        url("http://127.0.0.1:8080/mensaje")
        contentType(ContentType.Application.Json)
        setBody(Json.encodeToString(Mensaje(message)))
    }
    println("Status després del POST: ${response.status}")

    response = client.get("http://127.0.0.1:8080/mensaje")
    println("Status després del GET: ${response.status}")

    val mensaje = Json.decodeFromString<List<Mensaje>>(response.bodyAsText())
    println(mensaje)
    for (c in mensaje) {
        println("Mensaje: ${c.mensaje}")
    }

    client.close()
}
