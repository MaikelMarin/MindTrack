package com.vipermech.mindtrack.presentation.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.vipermech.mindtrack.domain.repository.AuthRepository
import com.vipermech.mindtrack.presentation.ui.state.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private val _user = MutableStateFlow<FirebaseUser?>(null)
    val user = _user.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val result = repository.login(email, password)
                result
                    .onSuccess {
                        _uiState.emit(LoginUiState(user = it, error = null))
                        _user.emit(it)
                    }
                    .onFailure {
                        _uiState.emit(LoginUiState(error = it.message))
                    }
            } catch (e: Exception) {
                _uiState.emit(LoginUiState(error = e.message))
            }
        }
    }

    fun register(email: String, password: String) {
        // Implement registration logic here
    }

    fun sendEmailVerification() {
        // Implement email verification logic here
    }



    fun logout() {
        viewModelScope.launch {
            repository.logout()
            _uiState.emit(LoginUiState())  // Reset state after logout
            _user.emit(null)  // Clear the user state
        }
    }

    fun forgotPassword(email: String) {
        //Logic for forgot password
    }
}