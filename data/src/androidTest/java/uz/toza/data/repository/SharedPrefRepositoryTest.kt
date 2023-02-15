package uz.toza.data.repository

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SharedPrefRepositoryTest {

    private lateinit var sharedPrefRepository: SharedPrefRepository

    @Before
    fun initShared() {
        val context = ApplicationProvider.getApplicationContext<Context>().applicationContext
        sharedPrefRepository =
            SharedPrefRepository(context)
    }

    @Test
    fun saveUserID() {
        val userId = "155L"
        sharedPrefRepository.saveUserId(userId)
        val actual = sharedPrefRepository.getLongId()
        Assert.assertEquals(userId, actual)
    }

    @Test
    fun saveApplicationLang(){
        val lang="uz"
        sharedPrefRepository.saveLang(lang)
        val actual=sharedPrefRepository.getLang()
        Assert.assertEquals(lang,actual)
    }
}