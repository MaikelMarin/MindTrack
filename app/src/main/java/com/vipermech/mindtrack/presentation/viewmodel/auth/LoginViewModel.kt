package com.vipermech.mindtrack.presentation.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.vipermech.mindtrack.domain.repository.AuthRepository
import com.vipermech.mindtrack.presentation.ui.state.AuthUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    private val _user = MutableStateFlow<FirebaseUser?>(null)
    val user = _user.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val result = repository.login(email, password)
                result
                    .onSuccess {
                        _uiState.emit(AuthUiState(user = it, error = null))
                        _user.emit(it)
                    }
                    .onFailure {
                        _uiState.emit(AuthUiState(error = it.message))
                    }
            } catch (e: Exception) {
                _uiState.emit(AuthUiState(error = e.message))
            }
        }
    }

    fun register(email: String, password: String) {
        // Implement registration logic here
    }

/*
    fun logout() {
        viewModelScope.launch {
            repository.logout()
            _uiState.emit(AuthUiState())  // Reset state after logout
            _user.emit(null)  // Clear the user state
        }
    }
*/

    fun forgotPassword(email: String) {
        //Logic for forgot password
    }
}