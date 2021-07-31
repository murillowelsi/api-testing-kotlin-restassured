package tests.users

import io.restassured.RestAssured.given
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.Test;
import services.getAllUsers
import tests.core.BaseTest
import tests.core.Instance.base_url

@DisplayName("GET /usuarios")
class GetAllUsersTest : BaseTest() {

    @Test
    @DisplayName("first user data should be valid")
    fun test001() {
        given().baseUri(base_url).`when`()
            .get("/usuarios")
            .then()
            .statusCode(200)

            .body("usuarios[0].nome", equalTo("Fulano da Silva"))
            .body("usuarios[0].email", equalTo("fulano@qa.com"))
            .body("usuarios[0].password", equalTo("teste"))
            .body("usuarios[0].administrador", equalTo("true"))
    }

    @Test
    @DisplayName("extract first user name")
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
    @DisplayName("first user name should be Fulano da Silva")
    fun test003() {
        Given {
            baseUri(base_url)
        } When {
            get("/usuarios")
        } Then {
            statusCode(200)
            body("usuarios[0].nome", equalTo("Fulano da Silva"))
        }
    }

    @Test
    @DisplayName("actual response should be equals to the expected one")
    fun test004() {
        val response = getAllUsers()
            .extract()
            .response()
            .asPrettyString()

        assertThat(response, containsString("\"email\": \"Lucinda_Cruickshank48@gmail.com\""))
    }
}