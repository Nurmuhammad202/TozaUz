package uz.toza.domain.usecase

import uz.toza.domain.repository.LocalRepository

class SetTokenUseCase(private val localRepository: LocalRepository) {
    fun execute(token: String) {
        return localRepository.saveUserId(token)
    }
}