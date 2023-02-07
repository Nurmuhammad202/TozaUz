package uz.toza.domain.model

data class GetOrderHistory(
    val finish_at: Any,
    val qr_info: List<String>,
    val start_at: Any,
    val status: String
)