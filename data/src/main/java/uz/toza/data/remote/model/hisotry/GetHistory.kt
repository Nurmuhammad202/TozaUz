package uz.toza.data.remote.model.hisotry

data class GetHistory(
    val finish_at: Any? = null,
    val qr_info: List<String>,
    val start_at: Any? = null,
    val status: String
)