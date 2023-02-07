package uz.toza.domain.usecase

import uz.toza.domain.model.MyProfile
import uz.toza.domain.repository.RemoteRepository

class ProfileUseCase(private val remoteRepository: RemoteRepository) {
    suspend fun profileUseCase(userId: Long): MyProfile {
        return remoteRepository.myProfile(userId)
    }
}