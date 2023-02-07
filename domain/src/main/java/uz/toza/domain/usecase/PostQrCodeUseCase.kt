package uz.toza.domain.usecase

import uz.toza.domain.repository.RemoteRepository

class PostQrCodeUseCase(private val remoteRepository: RemoteRepository) {
    suspend fun executePostQrCode(qrCode: String, userId: Long) {
        remoteRepository.postQrCode(qrCode = qrCode, userId = userId)
    }
}