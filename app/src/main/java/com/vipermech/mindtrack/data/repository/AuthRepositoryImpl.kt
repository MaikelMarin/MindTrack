package com.vipermech.mindtrack.data.repository

import com.google.firebase.auth.FirebaseUser
import com.vipermech.mindtrack.data.firebase.FirebaseAuthSource
import com.vipermech.mindtrack.domain.repository.AuthRepository
import javax.inject.Inject

/**
 * Implementation of the [AuthRepository] interface.
 */

class AuthRepositoryImpl @Inject constructor(private val source: FirebaseAuthSource): AuthRepository {
    override suspend fun login(email: String, password: String): Result<FirebaseUser> {
        return source.login(email, password)
    }

    override suspend fun register(email: String, password: String): Result<FirebaseUser> {
        return source.register(email,password)
    }

    override fun logout() {
        source.logout()
    }

    override fun currentUser(): FirebaseUser? {
        return source.currentUser()
    }

}