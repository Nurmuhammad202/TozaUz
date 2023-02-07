package uz.toza.domain.usecase

import uz.toza.domain.repository.LocalRepository
import uz.toza.domain.repository.RemoteRepository

class PostQrCodeUseCase(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) {
    suspend fun executePostQrCode(qrCode: String): Boolean {
        localRepository.getLongId()
        return remoteRepository.postQrCode(qrCode = qrCode, userId =  localRepository.getLongId())
    }
}