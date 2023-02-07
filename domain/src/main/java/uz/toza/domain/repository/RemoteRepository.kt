package uz.toza.domain.repository

import uz.toza.domain.model.BalanceUseCaseModel
import uz.toza.domain.model.BodyHistoryModel
import uz.toza.domain.model.GetOrderHistory
import uz.toza.domain.model.MyProfile

interface RemoteRepository {
    suspend fun postQrCode(qrCode: String, userId: Long): Boolean

    suspend fun getBalance(userId: Long): BalanceUseCaseModel

    suspend fun getHistory(bodyHistoryModel: BodyHistoryModel): GetOrderHistory

    suspend fun qrToday(userId: Long): Boolean

    suspend fun myProfile(userId: Long):MyProfile
}