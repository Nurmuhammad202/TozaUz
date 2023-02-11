package uz.toza.data.extension

import retrofit2.Response

fun <T> success(data: Response<T>): Boolean {
    return data.isSuccessful && data.code() == 200
}

typealias Mapper<Input, Output> = (Input) -> Output

sealed class Result<T> {
    fun <R> map(mapper: Mapper<T, R>? = null): Result<R> = when (this) {
        is PaddingResult -> PaddingResult()
        is ErrorResult -> ErrorResult(this.exception)
        is SuccessResult -> {
            if (mapper == null) throw IllegalAccessException("Mapper should not NULL for success result")
            SuccessResult(mapper(this.data))
        }
    }
}

class PaddingResult<T> : Result<T>()

class SuccessResult<T>(
    val data: T,
) : Result<T>()

class ErrorResult<T>(val exception: Exception) : Result<T>()
