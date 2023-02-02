package uz.toza.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.toza.data.remote.module.balance.BodyBalance
import uz.toza.data.remote.module.balance.GetBalance
import uz.toza.data.remote.module.qrCode.BodyQrCode
import uz.toza.data.remote.module.qrCode.GetQrCodeResponse

interface ApiInterface {

    @POST("balance")
    suspend fun getBalance(
        @Body bodyBalance: BodyBalance
    ): Response<GetBalance>


    @POST("qr_scaner")
    suspend fun getQrCode(
        @Body bodyQrCode: BodyQrCode
    ): Response<GetQrCodeResponse>


}