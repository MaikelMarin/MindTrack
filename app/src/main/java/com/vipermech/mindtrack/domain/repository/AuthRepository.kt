package com.vipermech.mindtrack.domain.repository

import com.google.firebase.auth.FirebaseUser
import kotlinx.serialization.Serializable

/**
 * Interface for the authentication repository.
 */


interface AuthRepository {
    suspend fun login(email: String, password: String):  Result<FirebaseUser>
    suspend fun register(email: String, password: String): Result<FirebaseUser>
    fun sendEmailVerification(user: FirebaseUser): Result<Boolean>
    fun logout()
    fun currentUser(): FirebaseUser?
    suspend fun forgotPassword(email: String): Result<Boolean>
    suspend fun deleteAccount(user: FirebaseUser): Result<Boolean>

}