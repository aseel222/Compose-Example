package com.example.jetpackcompose.gyms.presentaion.gymslist

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.gyms.domain.GetAllGysUseCase
import com.example.jetpackcompose.gyms.domain.ToggleFavStatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class GymViewModel @Inject constructor (
    private val getallgymsuseCase:GetAllGysUseCase,
        private val togglefavstateuseCase:ToggleFavStatesUseCase,)
    :ViewModel(){
  private  var _state =
        mutableStateOf(GymsScreenState(gymslist =  emptyList(), isloading = true))
    val state:State<GymsScreenState>
        get() = derivedStateOf {
            _state.value
        }


    private val errorhandeler= CoroutineExceptionHandler {
            coroutineContext, throwable ->
        throwable.printStackTrace()
        _state.value=_state.value.copy(error = throwable.message, isloading = false)

    }
  init  {

      getgyms()
    }


      fun getgyms(){
viewModelScope.launch(errorhandeler) {
    val receivedgyms=getallgymsuseCase()
        _state.value=_state.value.copy(gymslist = receivedgyms, isloading = false)


}
         }


    fun togglestate(gymid:Int,oldvalue:Boolean){
        viewModelScope.launch { val updatedgymlist=togglefavstateuseCase(gymid,oldvalue)
           _state.value=_state.value.copy(gymslist = updatedgymlist)
        }


    }









}