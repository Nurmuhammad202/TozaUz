package uz.toza.tozauz.ui.fragment.history

import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.toza.domain.model.GetOrderHistory
import uz.toza.domain.model.QrInfo
import uz.toza.domain.model.history.HistoryList
import uz.toza.domain.usecase.HistoryUseCase
import uz.toza.tozauz.utils.date.dateConvert
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class HistoryViewModel @Inject constructor(private val historyUseCase: HistoryUseCase) :
    ViewModel() {

    private var _getOrderHistory = MutableLiveData<HistoryList>()
    val getOrderHistory: LiveData<HistoryList> = _getOrderHistory
    fun getHistory(startTime: String, endTime: String) = viewModelScope.launch {
        try {
            val item=historyUseCase.execute(startTime, endTime)
            Log.d(TAG, "getHistory:-->$item ")
            _getOrderHistory.value = historyUseCase.execute(startTime, endTime)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}