package uz.toza.domain.usecase

import uz.toza.domain.model.BodyHistoryModel
import uz.toza.domain.model.GetOrderHistory
import uz.toza.domain.model.QrInfo
import uz.toza.domain.repository.LocalRepository
import uz.toza.domain.repository.RemoteRepository

class HistoryUseCase(private val remoteRepository: RemoteRepository,private val localRepository: LocalRepository) {
    suspend fun execute(startTime: String, endTime: String): ArrayList<QrInfo> {
        val bodyHistoryModel = BodyHistoryModel(endTime, startTime, localRepository.getLongId().toInt())
        val response = remoteRepository.getHistory(bodyHistoryModel)
        val qrInfo = ArrayList<QrInfo>()
        response.qr_info.forEach {
            val type = it.split("\"code_type_name\":")[1].split("\"price\"")[0]
            val data = it.split("\"date\":")[1]
            val price = it.split("\"price\":")[1].split("\"date\"")[0]
            qrInfo.add(QrInfo(type, price, data))
        }
        return qrInfo
    }
}