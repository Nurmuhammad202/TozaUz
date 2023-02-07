package uz.toza.domain.usecase

import uz.toza.domain.repository.RemoteRepository

class QrTodayUseCase(private val remoteRepository: RemoteRepository) {

    suspend fun getQrToday(userId: Long): Boolean {
        return remoteRepository.qrToday(userId = userId)
    }
}