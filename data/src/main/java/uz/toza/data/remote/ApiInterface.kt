package uz.toza.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.toza.data.remote.module.balance.BodyBalance
import uz.toza.data.remote.module.balance.GetBalance
import uz.toza.data.remote.module.baseResponse.BaseResponse
import uz.toza.data.remote.module.hisotry.BodyHistory
import uz.toza.data.remote.module.hisotry.GetHistory
import uz.toza.data.remote.module.history.MyProfile
import uz.toza.data.remote.module.qrCode.BodyQrCode
import uz.toza.data.remote.module.qrCode.GetQrCodeResponse
import uz.toza.data.remote.module.today.TodayModel

interface ApiInterface {

    @POST("balance")
    suspend fun getBalance(
        @Body bodyBalance: BodyBalance
    ): Response<GetBalance>


    @POST("qr_scaner")
    suspend fun getQrCode(
        @Body bodyQrCode: BodyQrCode
    ): Response<GetQrCodeResponse>

    @POST("history")
    suspend fun history(
        @Body bodyHistory: BodyHistory
    ): Response<GetHistory>

    @POST("qr_today")
    suspend fun qrToday(
        @Body bodyBalance: BodyBalance
    ): Response<TodayModel>

    @POST("myprofile")
    suspend fun profile(
        @Body bodyBalance: BodyBalance
    ):Response<MyProfile>
}