package uz.toza.domain.usecase

import uz.toza.domain.repository.LocalRepository

class GetLangUseCase constructor(private var localRepository: LocalRepository) {
    fun execute(): String {
        return localRepository.getLang()
    }
}