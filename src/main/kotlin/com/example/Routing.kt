package com.example

import io.ktor.http.ContentDisposition
import io.ktor.http.HttpHeaders
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/downloadImage") {
            var file = File("files/image.jpeg")
            call.response.header(
                HttpHeaders.ContentDisposition,
                ContentDisposition.Attachment.withParameter(
                    ContentDisposition.Parameters.FileName, "image.jpg"
                ).toString()
            )
            call.respondFile(file)
        }
        get("/showImage") {
            var file = File("files/image.jpeg")
            call.response.header(
                HttpHeaders.ContentDisposition,
                ContentDisposition.Inline.withParameter(
                    ContentDisposition.Parameters.FileName, "image.jpg"
                ).toString()
            )
            call.respondFile(file)
        }
    }
}
