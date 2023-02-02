package uz.toza.data.repository

import uz.toza.data.remote.ApiInterface
import uz.toza.data.remote.module.balance.BodyBalance
import uz.toza.data.remote.module.qrCode.BodyQrCode

class RemoteRepository(private val apiInterface: ApiInterface) {

    suspend fun postQrCode(qrCode: String, userId: Long) {
        val bodyQrCode = BodyQrCode(code = qrCode, userId = userId)
        apiInterface.getQrCode(bodyQrCode)
    }

    suspend fun getBalance(userId: Long) {
        val bodyBalance = BodyBalance(userId = userId)
        apiInterface.getBalance(bodyBalance)
    }
}