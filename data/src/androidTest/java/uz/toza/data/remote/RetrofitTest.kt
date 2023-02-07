package uz.toza.data.remote

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import uz.toza.data.remote.module.balance.BodyBalance
import uz.toza.data.remote.module.hisotry.BodyHistory
import uz.toza.data.remote.module.qrCode.BodyQrCode
import uz.toza.data.remote.retrofitBuilder.RetrofitBuilder

class RetrofitTest {

    private lateinit var apiInterface: ApiInterface

    @Before
    fun initApiInterface() {
        apiInterface = RetrofitBuilder.apiInterfaceBuilder()
    }

    @Test
    fun getBalance() = runBlocking{
        val bodyBalance = BodyBalance(userId = 1)
        val expected = apiInterface.getBalance(bodyBalance).body()?.balance
        val actual = "10000"
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun postQrCode() = runBlocking{
        val postQrCode = BodyQrCode(code = "123", userId = 1)
        val expected = apiInterface.getQrCode(postQrCode).body()?.status
        val actual = "S"
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun history()= runBlocking {
        val postQrCode = BodyHistory("01.01.2023","02.01.2023",1)
        val expected = apiInterface.history(postQrCode).body()?.status
        val actual = "S"
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun qrToday() = runBlocking {
        val bodyBalance = BodyBalance(userId = 1)
        val expected = apiInterface.qrToday(bodyBalance).body()?.status
        val actual = "S"
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun profile() = runBlocking{
        val profileBody=BodyBalance(userId = 1)
        val expected=apiInterface.profile(profileBody).body()?.status
        val actual="S"
        Assert.assertEquals(expected,actual)
    }

}