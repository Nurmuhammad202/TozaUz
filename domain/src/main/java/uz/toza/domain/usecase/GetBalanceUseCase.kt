package uz.toza.domain.usecase

import uz.toza.domain.model.BalanceUseCaseModel
import uz.toza.domain.repository.RemoteRepository

class GetBalanceUseCase(private val remoteRepository: RemoteRepository) {
    suspend fun execute(userId: Long): BalanceUseCaseModel {
        return remoteRepository.getBalance(userId)
    }
}