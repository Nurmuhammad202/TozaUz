package uz.toza.domain.usecase

import uz.toza.domain.repository.LocalRepository

class GetTokenUseCase(private val localRepository: LocalRepository) {
    fun execute(): String {
        return localRepository.getLongId()
    }
}