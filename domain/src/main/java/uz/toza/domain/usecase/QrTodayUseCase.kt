package uz.toza.domain.usecase

import uz.toza.domain.model.QrCodeConvert
import uz.toza.domain.model.QrCodeToday
import uz.toza.domain.repository.RemoteRepository

class QrTodayUseCase(private val remoteRepository: RemoteRepository) {

    suspend fun getQrToday(userId: Long): ArrayList<QrCodeConvert> {
        val response = remoteRepository.qrToday(userId = userId)
        val qrCodeConvert = ArrayList<QrCodeConvert>()
        response.qr_info.forEach {
            val type = it.split("\"name\":")[1].split("\"balance\"")[0]
            val price = it.split("\"summa\":")[1]
            qrCodeConvert.add(QrCodeConvert(type = type, summa = price+" so'm"))
        }
        return qrCodeConvert
    }
}