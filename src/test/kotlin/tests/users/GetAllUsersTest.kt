package tests.users

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import services.getAllUsers
import tests.core.BaseTest

@DisplayName("GET /usuarios")
class GetAllUsersTest : BaseTest() {

    @Test
    @DisplayName("quantidade should be equals 1")
    fun test001() {
        val response = getAllUsers().body.jsonPath()

        assertThat(response.get("quantidade"), equalTo(1))
        assertThat(response.get("usuarios[0].nome"), equalTo("Fulano da Silva"))
        assertThat(response.get("usuarios[0].email"), equalTo("fulano@qa.com"))
        assertThat(response.get("usuarios[0].password"), equalTo("teste"))
        assertThat(response.get("usuarios[0].administrador"), equalTo("true"))
    }
}