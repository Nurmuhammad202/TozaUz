package uz.toza.data.local

interface LocalRepository {

    fun saveUserId(long: Long)

    fun getLongId(): Long

    fun saveLang(lang: String)

    fun getLang(): String
}