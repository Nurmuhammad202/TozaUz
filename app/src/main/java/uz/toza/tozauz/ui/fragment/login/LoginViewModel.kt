package uz.toza.tozauz.ui.fragment.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.toza.domain.usecase.GetTokenUseCase
import uz.toza.domain.usecase.SetTokenUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase,
    private val setTokenUseCase: SetTokenUseCase
) : ViewModel() {

    fun getToken(): String = getTokenUseCase.execute()

    fun setToken(token: String) = setTokenUseCase.execute(token)

}