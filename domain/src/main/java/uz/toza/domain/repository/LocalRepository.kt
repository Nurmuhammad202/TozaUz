package uz.toza.domain.repository

interface LocalRepository {

    fun saveUserId(long: Long)

    fun getLongId(): Long

    fun saveLang(lang: String)

    fun getLang(): String
}