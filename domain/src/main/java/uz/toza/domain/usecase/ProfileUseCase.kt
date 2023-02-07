package uz.toza.domain.usecase

import uz.toza.domain.model.MyProfile
import uz.toza.domain.repository.LocalRepository
import uz.toza.domain.repository.RemoteRepository

class ProfileUseCase(private val remoteRepository: RemoteRepository, private val localRepository: LocalRepository) {
    suspend fun profileUseCase(): MyProfile {
        return remoteRepository.myProfile(localRepository.getLongId())
    }
}