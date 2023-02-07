package uz.toza.domain.usecase

import uz.toza.domain.model.BodyHistoryModel
import uz.toza.domain.model.GetOrderHistory
import uz.toza.domain.repository.RemoteRepository

class HistoryUseCase(private val remoteRepository: RemoteRepository) {
    suspend fun execute(bodyHistoryModel: BodyHistoryModel): GetOrderHistory {
       return remoteRepository.getHistory(bodyHistoryModel)
    }
}