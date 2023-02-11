package uz.toza.domain.usecase

import uz.toza.domain.model.BodyHistoryModel
import uz.toza.domain.model.GetOrderHistory
import uz.toza.domain.model.QrInfo
import uz.toza.domain.model.history.HistoryList
import uz.toza.domain.repository.LocalRepository
import uz.toza.domain.repository.RemoteRepository

class HistoryUseCase(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) {
    suspend fun execute(startTime: String, endTime: String): HistoryList {
        val bodyHistoryModel =
            BodyHistoryModel(endTime, startTime, localRepository.getLongId().toInt())
        val response = remoteRepository.getHistory(bodyHistoryModel)
        val qrInfo = ArrayList<QrInfo>()
        var countType1 = 0
        var countType2 = 0
        response.qr_info.forEach {
            val type = it.split("\"code_type_name\":")[1].split("\"price\"")[0]
            val data = it.split("\"date\":")[1]
            val price = it.split("\"price\":")[1].split("\"date\"")[0]
            println(type)
            qrInfo.add(QrInfo(type, price, data))
            val item = type.replace(" ", "")
            println(type)
            if (item == type1) {
                countType1++
            } else if (item == type2) {
                countType2++
            }

        }

        println(countType1)
        println(countType2)

        return HistoryList(countType1, countType2, qrInfo)
    }

    companion object {
        private const val type1 = "Длябытовыхотходов"
        private const val type2 = "Длястроительныхотходов"
    }
}
