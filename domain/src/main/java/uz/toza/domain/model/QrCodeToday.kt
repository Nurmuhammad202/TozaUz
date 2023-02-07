package uz.toza.domain.model

data class QrCodeToday(
    val qr_info: List<String>,
    val status: String
)

data class QrCodeConvert(var type: String, var summa: String)