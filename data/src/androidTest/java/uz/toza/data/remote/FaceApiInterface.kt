package uz.toza.data.remote

import retrofit2.Response
import uz.toza.data.remote.model.balance.BodyBalance
import uz.toza.data.remote.model.balance.GetBalance
import uz.toza.data.remote.model.hisotry.BodyHistory
import uz.toza.data.remote.model.hisotry.GetHistory
import uz.toza.data.remote.model.history.MyProfile
import uz.toza.data.remote.model.qrCode.BodyQrCode
import uz.toza.data.remote.model.qrCode.GetQrCodeResponse
import uz.toza.data.remote.model.today.TodayModel

class FaceApiInterface : ApiInterface {
    override suspend fun getBalance(bodyBalance: BodyBalance): Response<GetBalance> {
        return Response.success(200, GetBalance("10", "S"))
    }

    override suspend fun getQrCode(bodyQrCode: BodyQrCode): Response<GetQrCodeResponse> {
        return Response.success(200, GetQrCodeResponse(""))
    }

    override suspend fun history(bodyHistory: BodyHistory): Response<GetHistory> {
        TODO("Not yet implemented")
    }

    override suspend fun qrToday(bodyBalance: BodyBalance): Response<TodayModel> {
        TODO("Not yet implemented")
    }

    override suspend fun profile(bodyBalance: BodyBalance): Response<MyProfile> {
        TODO("Not yet implemented")
    }
}