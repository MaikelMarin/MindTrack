package com.vipermech.mindtrack.presentation.ui.state

import com.google.firebase.auth.FirebaseUser

data class AuthUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val user: FirebaseUser? = null,
    val error: String? = null
)