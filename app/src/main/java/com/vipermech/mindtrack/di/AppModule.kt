package com.vipermech.mindtrack.di

import com.google.firebase.auth.FirebaseAuth
import com.vipermech.mindtrack.data.firebase.FirebaseAuthSource
import com.vipermech.mindtrack.data.repository.AuthRepositoryImpl
import com.vipermech.mindtrack.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepository(auth: FirebaseAuth): AuthRepository {
        return AuthRepositoryImpl(FirebaseAuthSource(auth))
    }

}
