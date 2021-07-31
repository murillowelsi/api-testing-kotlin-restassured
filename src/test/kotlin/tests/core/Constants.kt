package tests.core

object Instance {
    val BASE_URL: String? = System.getenv("BASE_URL")

    fun baseUrl(): String {
        return BASE_URL ?: "https://serverest.dev"
    }

    val base_url = baseUrl()
}