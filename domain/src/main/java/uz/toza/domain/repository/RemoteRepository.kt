package uz.toza.domain.repository

import uz.toza.domain.model.*

interface RemoteRepository {
    suspend fun postQrCode(qrCode: String, userId: String): Boolean

    suspend fun getBalance(userId: String): BalanceUseCaseModel

    suspend fun getHistory(bodyHistoryModel: BodyHistoryModel): GetOrderHistory

    suspend fun qrToday(userId: String): QrCodeToday

    suspend fun myProfile(userId: String):MyProfile
}