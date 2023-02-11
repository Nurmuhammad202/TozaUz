package uz.toza.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.toza.data.remote.model.balance.BodyBalance
import uz.toza.data.remote.model.balance.GetBalance
import uz.toza.data.remote.model.hisotry.BodyHistory
import uz.toza.data.remote.model.hisotry.GetHistory
import uz.toza.data.remote.model.history.MyProfile
import uz.toza.data.remote.model.qrCode.BodyQrCode
import uz.toza.data.remote.model.qrCode.GetQrCodeResponse
import uz.toza.data.remote.model.today.TodayModel

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