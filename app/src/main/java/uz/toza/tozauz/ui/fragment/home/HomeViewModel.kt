package uz.toza.tozauz.ui.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.toza.domain.model.QrCodeConvert
import uz.toza.domain.usecase.GetBalanceUseCase
import uz.toza.domain.usecase.PostQrCodeUseCase
import uz.toza.domain.usecase.QrTodayUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val qrTodayUseCase: QrTodayUseCase,
    private val getBalanceUseCase: GetBalanceUseCase,
    private val postQrCodeUseCase: PostQrCodeUseCase
) : ViewModel() {

    init {
        todayDate()
        getBalance()
    }

    private var _qrCodeToday = MutableLiveData<ArrayList<QrCodeConvert>>()
    val qrCodeToday: LiveData<ArrayList<QrCodeConvert>> = _qrCodeToday
    private fun todayDate() = viewModelScope.launch {
        try {
            _qrCodeToday.value = qrTodayUseCase.getQrToday()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    private var _balance = MutableLiveData<String>()
    val balance: LiveData<String> = _balance
    private fun getBalance() = viewModelScope.launch {
        try {
            _balance.value = getBalanceUseCase.execute()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    private var _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = _success
    fun postQrCode(qrcode: String) = viewModelScope.launch {
        try {
            _success.value = postQrCodeUseCase.executePostQrCode(qrcode)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

