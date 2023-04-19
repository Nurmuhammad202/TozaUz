package uz.toza.tozauz.ui.fragment.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.toza.domain.usecase.GetAuthTokenUseCase
import uz.toza.domain.usecase.GetTokenUseCase
import uz.toza.domain.usecase.SetAuthTokenUseCase
import uz.toza.domain.usecase.SetTokenUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase,
    private val setTokenUseCase: SetTokenUseCase,
    private val setAuthTokenUseCase: SetAuthTokenUseCase
) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    var isLoading:LiveData<Boolean> = _isLoading

    fun getToken(): String = getTokenUseCase.execute()

    fun setToken(token: String) = setTokenUseCase.execute(token)

    fun setAuthToken(phoneNumber: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            setAuthTokenUseCase.execute(phoneNumber, password)
            _isLoading.postValue(false)
        }
    }
}