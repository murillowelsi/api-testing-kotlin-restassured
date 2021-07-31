package tests.core

object Instance {
    private val BASE_URL: String? = System.getenv("BASE_URL")

    private fun baseUrl(): String {
        return BASE_URL ?: "https://serverest.dev"
    }

    val base_url = baseUrl()
}