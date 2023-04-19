package uz.toza.domain.repository

interface LocalRepository {

    fun saveUserId(long: String)

    fun getLongId(): String

    fun saveLang(lang: String)

    fun getLang(): String

    fun saveToken(token:String)

    fun getToken():String
}