package uz.toza.domain.model

data class AuthTokenModel(
    val token: String = "",
    val id: Int = 0,
    val phoneNumber: String = "",
    val firstName: String = "",
    val role: String = ""
)
