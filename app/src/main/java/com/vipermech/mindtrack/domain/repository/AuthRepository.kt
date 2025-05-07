package com.vipermech.mindtrack.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseUser

/**
 * Interface for the authentication repository.
 */


interface AuthRepository {
    suspend fun login(email: String, password: String):  Result<FirebaseUser>
    suspend fun register(email: String, password: String): Result<FirebaseUser>
    fun sendEmailVerification(user: FirebaseUser): Task<Void>
    fun logout()
    fun currentUser(): FirebaseUser?
    suspend fun forgotPassword(email: String): Result<Boolean>

}