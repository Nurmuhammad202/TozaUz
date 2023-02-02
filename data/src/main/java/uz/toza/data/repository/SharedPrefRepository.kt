package uz.toza.data.repository

import android.content.Context
import android.content.SharedPreferences
import uz.toza.data.local.LocalRepository

const val SHARED_PREF_NAME = "sharedPrefName"
const val SHARED_USER_ID = "sharedUserId"
const val SHARED_LANG = "language"
const val DEFAULT_LANG = "ru"

class SharedPrefRepository(context: Context) : LocalRepository {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun saveUserId(long: Long) {
        sharedPreferences.edit().putLong(SHARED_USER_ID, long).apply()
    }

    override fun getLongId(): Long {
        return sharedPreferences.getLong(SHARED_USER_ID, 0)
    }

    override fun saveLang(lang: String) {
        sharedPreferences.edit().putString(SHARED_LANG, lang).apply()
    }

    override fun getLang(): String {
        return sharedPreferences.getString(SHARED_LANG, DEFAULT_LANG) ?: DEFAULT_LANG
    }
}