package uz.toza.tozauz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.toza.domain.repository.LocalRepository
import uz.toza.domain.usecase.GetLangUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private var getLangUseCase: GetLangUseCase) : ViewModel() {


    fun getLang(): String = getLangUseCase.execute()

}