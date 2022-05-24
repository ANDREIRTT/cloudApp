package com.mal.cloud.future_auth.presentation


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mal.cloud.future_auth.domain.AuthUseCase
import com.mal.cloud.future_auth.domain.dto.AuthResponse
import com.mal.cloud.future_auth.domain.dto.UserRole
import com.mal.cloud.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    private val mutableLiveData: MutableLiveData<UIState<AuthResponse>> by lazy {
        MutableLiveData()
    }

    fun login(username: String, password: String) {
        viewModelScope.launch {
            mutableLiveData.postValue(UIState.Loading())
            sendResponse(authUseCase.login(username, password))
        }
    }

    fun register(username: String, password: String, userRole: UserRole) {
        viewModelScope.launch {
            mutableLiveData.postValue(UIState.Loading())
            sendResponse(authUseCase.register(username, password, userRole))
        }
    }

    private fun sendResponse(response: AuthResponse) {
        when (response) {
            is AuthResponse.Success -> {
                mutableLiveData.postValue(UIState.Success(response))
            }
            is AuthResponse.Error -> {
                mutableLiveData.postValue(UIState.Error(response.authErrorData.message))
            }
        }
    }
}