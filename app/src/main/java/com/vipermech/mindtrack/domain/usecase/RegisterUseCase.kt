package com.vipermech.mindtrack.domain.usecase

import com.google.firebase.auth.FirebaseUser
import com.vipermech.mindtrack.domain.repository.AuthRepository
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RegisterUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<FirebaseUser> {
        return withContext(Dispatchers.IO) {
            if (email.isBlank() || password.isBlank()) {
                return@withContext Result.failure(Exception("Correo o contraseña vacíos"))
            }
            repository.register(email, password)
        }
    }
}
