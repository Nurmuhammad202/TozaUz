package uz.toza.tozauz

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.toza.domain.usecase.GetLangUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private var getLangUseCase: GetLangUseCase) : ViewModel() {


    fun getLang(): String = getLangUseCase.execute()

}