package uz.toza.domain.usecase

import uz.toza.domain.model.BalanceUseCaseModel
import uz.toza.domain.repository.LocalRepository
import uz.toza.domain.repository.RemoteRepository

class GetBalanceUseCase(private val remoteRepository: RemoteRepository,private val localRepository: LocalRepository) {
    suspend fun execute(): String {
        return remoteRepository.getBalance(localRepository.getLongId()).balance + " so'm"
    }
}