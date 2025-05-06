package com.vipermech.mindtrack.data.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

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


    fun logout() = auth.signOut()

    fun currentUser(): FirebaseUser? = auth.currentUser


}