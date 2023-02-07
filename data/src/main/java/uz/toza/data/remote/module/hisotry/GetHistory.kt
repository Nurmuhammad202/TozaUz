package uz.toza.data.remote.module.hisotry

data class GetHistory(
    val finish_at: Any,
    val qr_info: List<String>,
    val start_at: Any,
    val status: String
)