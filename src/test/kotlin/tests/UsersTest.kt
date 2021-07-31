package tests

import io.restassured.RestAssured.given
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import tests.core.BaseTest
import tests.core.Instance.base_url
import tests.services.getAllUsers

@DisplayName("GET /usuarios")
class UsersTest : BaseTest() {

    @Test
    @DisplayName("first user data should be valid")
    fun test001() {
        given().
            baseUri(base_url).
        `when`()
            .get("/usuarios")
        .then()
            .statusCode(200)

            .body("usuarios[0].nome", equalTo("Fulano da Silva"))
            .body("usuarios[0].email", equalTo("fulano@qa.com"))
            .body("usuarios[0].password", equalTo("teste"))
            .body("usuarios[0].administrador", equalTo("true"))
    }

    @Test
    fun test002() {
        val nome: String =
            Given {
                baseUri(base_url)
            } When {
                get("/usuarios")
            } Then {
                statusCode(200)
                body("usuarios[0].nome", equalTo("Fulano da Silva"))
            } Extract {
                path("usuarios[0].nome")
            }
        println(nome)
    }

    @Test
    @DisplayName("actual response should be equals to the expected one")
    fun test05() {
        val expectedResponse = "{\n" +
                "    \"quantidade\": 1,\n" +
                "    \"usuarios\": [\n" +
                "        {\n" +
                "            \"nome\": \"Fulano da Silva\",\n" +
                "            \"email\": \"fulano@qa.com\",\n" +
                "            \"password\": \"teste\",\n" +
                "            \"administrador\": \"true\",\n" +
                "            \"_id\": \"0uxuPY0cbmQhpEz1\"\n" +
                "        }\n" +
                "    ]\n" +
                "}"

        val response = getAllUsers()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .response()
            .asString()

        assertThat(response, containsString(expectedResponse))
    }

    @Test
    fun test003() {
        val nome: String =
            Given {
                baseUri(base_url)
            } When {
                get("/usuarios")
            } Then {
                statusCode(200)
                body("usuarios[0].nome", equalTo("Fulano da Silva"))
            } Extract {
                path("usuarios[0].nome")
            }
        println(nome)
    }
}