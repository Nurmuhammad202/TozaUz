package uz.toza.domain.usecase

import uz.toza.domain.repository.LocalRepository

class GetAuthTokenUseCase constructor(private var localRepository: LocalRepository) {
    fun execute(): String {
        return localRepository.getToken()
    }
}