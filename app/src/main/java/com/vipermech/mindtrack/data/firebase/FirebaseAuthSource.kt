package com.vipermech.mindtrack.data.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

/**
 * Source class for Firebase Authentication.
 */

class FirebaseAuthSource @Inject constructor(auth: FirebaseAuth) {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    suspend fun login(email: String, password: String): Result<FirebaseUser> =
        withContext(Dispatchers.IO) {
            try {
                val result = auth.signInWithEmailAndPassword(email, password).await()
                Result.success(result.user!!)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }

    suspend fun register(email: String, password: String): Result<FirebaseUser> =
        withContext(Dispatchers.IO) {

            try {
                val result = auth.createUserWithEmailAndPassword(email, password).await()
                Result.success(result.user!!)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }


    fun sendEmailVerification(user: FirebaseUser): Task<Void> = user.sendEmailVerification().addOnCompleteListener {
        if (it.isSuccessful) {
            Result.success(true)
        } else {
            Result.failure(it.exception!!)
        }
    }

    fun logout() = auth.signOut()

    fun currentUser(): FirebaseUser? = auth.currentUser

    suspend fun forgotPassword(email: String): Result<Boolean> = try {
        auth.sendPasswordResetEmail(email).await()
        Result.success(true)
    } catch (e: Exception) {
        Result.failure(e)
    }

    fun deleteAccount(user: FirebaseUser): Task<Void> = user.delete().addOnCompleteListener {
        if (it.isSuccessful) {
            Result.success(true)
        } else {
            Result.failure(it.exception!!)
        }
    }


}