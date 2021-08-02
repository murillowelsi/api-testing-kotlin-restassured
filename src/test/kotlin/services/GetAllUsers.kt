package services

import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response
import tests.core.Instance.base_url


fun getAllUsers(): Response {
    return Given {
        baseUri(base_url)
    } When {
        get("/usuarios")
    } Then {
        statusCode(200)
    } Extract {
        response()
    }
}