package uz.toza.data.remote.model.baseResponse

data class BaseResponse<T>(
    val successful: Boolean,
    val message: String,
    val data: T,
    val status: Int = 200
)