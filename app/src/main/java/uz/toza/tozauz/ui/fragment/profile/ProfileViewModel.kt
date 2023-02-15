package uz.toza.tozauz.ui.fragment.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.toza.domain.usecase.GetLangUseCase
import uz.toza.domain.usecase.SetLangUseCase
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private var getLangUseCase: GetLangUseCase,
    private val setLangUseCase: SetLangUseCase
) : ViewModel() {

    private var _lang = MutableLiveData<String>()
    val lang: LiveData<String> = _lang
    fun getLang() = viewModelScope.launch {
        _lang.value = getLangUseCase.execute()
    }

    fun setLang(lang: String) = setLangUseCase.execute(lang)
}