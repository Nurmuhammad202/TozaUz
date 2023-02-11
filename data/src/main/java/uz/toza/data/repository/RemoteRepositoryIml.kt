package uz.toza.data.repository

import uz.toza.data.extension.success
import uz.toza.data.remote.ApiInterface
import uz.toza.data.remote.model.balance.BodyBalance
import uz.toza.data.remote.model.hisotry.BodyHistory
import uz.toza.data.remote.model.qrCode.BodyQrCode
import uz.toza.domain.model.*
import uz.toza.domain.repository.RemoteRepository

class RemoteRepositoryIml(private val apiInterface: ApiInterface) : RemoteRepository {

    override suspend fun postQrCode(qrCode: String, userId: Long): Boolean {
        val bodyQrCode = BodyQrCode(code = qrCode, userId = userId)
        val response = apiInterface.getQrCode(bodyQrCode)
        return success(response)
    }

    override suspend fun getBalance(userId: Long): BalanceUseCaseModel {
        val bodyBalance = BodyBalance(userId = userId)
        val response = apiInterface.getBalance(bodyBalance)
        if (success(response)) {
            response.body()?.let {
                return BalanceUseCaseModel(it.balance, it.status)
            }
        }

        return BalanceUseCaseModel("0", "error")
    }

    override suspend fun getHistory(bodyHistoryModel: BodyHistoryModel): GetOrderHistory {
        val bodyHistory = BodyHistory(
            bodyHistoryModel.finish_id,
            bodyHistoryModel.start_id,
            bodyHistoryModel.user_id
        )
        val response = apiInterface.history(bodyHistory = bodyHistory)
        if (success(response)) {
            response.body()?.let {
                return GetOrderHistory(
                    finish_at = it.finish_at ?: "",
                    qr_info = it.qr_info,
                    start_at = it.start_at ?: "",
                    status = it.status
                )
            }
        }
        return GetOrderHistory("", mutableListOf(), "0", "error")
    }

    override suspend fun qrToday(userId: Long): QrCodeToday {
        val response = apiInterface.qrToday(BodyBalance(userId = userId))
        if (success(response)) {
            response.body()?.let {
                return QrCodeToday(it.qr_info, it.status)
            }
        }
        return QrCodeToday(mutableListOf(), "")
    }

    override suspend fun myProfile(userId: Long): MyProfile {
        val response = apiInterface.profile(BodyBalance(userId = userId))
        if (success(response)) {
            response.body()?.let {
                return MyProfile(it.account, it.name, it.phone, it.status, it.tarif, it.username)
            }
        }
        return MyProfile("", "", "", "", mutableListOf(), "")
    }
}

