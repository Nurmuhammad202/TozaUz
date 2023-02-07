package uz.toza.domain.repository

import uz.toza.domain.model.*

interface RemoteRepository {
    suspend fun postQrCode(qrCode: String, userId: Long): Boolean

    suspend fun getBalance(userId: Long): BalanceUseCaseModel

    suspend fun getHistory(bodyHistoryModel: BodyHistoryModel): GetOrderHistory

    suspend fun qrToday(userId: Long): QrCodeToday

    suspend fun myProfile(userId: Long):MyProfile
}