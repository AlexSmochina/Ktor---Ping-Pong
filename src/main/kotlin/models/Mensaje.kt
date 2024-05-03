package models

import kotlinx.serialization.Serializable

@Serializable
data class Mensaje(val mensaje: String)

val mensajeStorage = mutableListOf<Mensaje>()