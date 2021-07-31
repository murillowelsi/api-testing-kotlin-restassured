package tests.services

import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.ValidatableResponse
import tests.core.Instance.base_url

fun getAllUsers(): ValidatableResponse {
    return Given {
        baseUri(base_url)
    } When {
        get("/usuarios")
    } Then {
        statusCode(200)
    }
}