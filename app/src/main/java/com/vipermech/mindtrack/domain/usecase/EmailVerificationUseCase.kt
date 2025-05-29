package com.vipermech.mindtrack.domain.usecase

import com.google.firebase.auth.FirebaseUser
import com.vipermech.mindtrack.domain.repository.AuthRepository
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EmailVerificationUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(user: FirebaseUser): Result<Boolean> {
        return withContext(Dispatchers.IO) {
           if(repository.sendEmailVerification(user).isSuccess){
               Result.success(true)
           }else{
               Result.failure(Exception("Failed to send email verification"))
           }
        }
        }
    }
