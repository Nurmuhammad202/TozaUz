package uz.toza.data.remote.model.auth

data class AuthTokenResponse(
    val token: String,
    val id: Int,
    val phone_number: String,
    val first_name: String,
    val role: String
)
