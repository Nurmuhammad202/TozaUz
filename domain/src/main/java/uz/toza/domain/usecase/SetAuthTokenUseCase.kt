package uz.toza.domain.usecase

import uz.toza.domain.repository.LocalRepository
import uz.toza.domain.repository.RemoteRepository

class SetAuthTokenUseCase(private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository) {
    suspend fun execute(phoneNumber: String, password:String) {
        val response = remoteRepository.getToken(phoneNumber, password)
        if (response.token.isNotBlank()) {
            localRepository.saveToken(response.token)
        }
    }
}