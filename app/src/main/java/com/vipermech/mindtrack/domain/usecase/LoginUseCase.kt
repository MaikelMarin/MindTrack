package com.vipermech.mindtrack.domain.usecase

import com.vipermech.mindtrack.domain.repository.AuthRepository
import jakarta.inject.Inject
import kotlinx.serialization.Serializable

@Serializable
class LoginUseCase @Inject constructor( private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}