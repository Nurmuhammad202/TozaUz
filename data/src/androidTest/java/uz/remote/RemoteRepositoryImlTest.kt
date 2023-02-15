package uz.remote

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import uz.toza.data.repository.RemoteRepositoryIml

class RemoteRepositoryImlTest {

    private var faceApiInterface = FaceApiInterface()
    private var remoteRepositoryIml = RemoteRepositoryIml(faceApiInterface)

    @Test
    fun postQrCode() = runBlocking {
        val expected = remoteRepositoryIml.postQrCode("123", "1")
        val actual = true
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun getBalanceRepository() = runBlocking {
        val expected = remoteRepositoryIml.getBalance( userId = "1")
        val actual = "S"
        Assert.assertEquals(expected.status,actual)
    }

}

