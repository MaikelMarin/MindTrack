package com.vipermech.mindtrack.domain.usecase

import com.vipermech.mindtrack.domain.repository.AuthRepository
import jakarta.inject.Inject

class LogoutUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke() {
        repository.logout()
    }
}