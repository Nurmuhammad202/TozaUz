package uz.toza.domain.usecase

import uz.toza.domain.repository.LocalRepository

class SetLangUseCase constructor(private var localRepository: LocalRepository) {
    fun execute(lang: String) {
        localRepository.saveLang(lang)
    }
}