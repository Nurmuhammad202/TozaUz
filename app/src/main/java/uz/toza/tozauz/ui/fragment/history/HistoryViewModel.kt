package uz.toza.tozauz.ui.fragment.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.toza.domain.model.GetOrderHistory
import uz.toza.domain.model.QrInfo
import uz.toza.domain.usecase.HistoryUseCase
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val historyUseCase: HistoryUseCase) :
    ViewModel() {

    private var _getOrderHistory = MutableLiveData<ArrayList<QrInfo>>()
    val getOrderHistory: LiveData<ArrayList<QrInfo>> = _getOrderHistory
    fun getHistory(startTime: String, endTime: String) = viewModelScope.launch {
        _getOrderHistory.value = historyUseCase.execute(startTime, endTime)
    }
}