package com.example.yesorno.di

import com.example.yesorno.data.repositories.MessageRepository
import com.example.yesorno.domain.interfaces.factory.MainFactoryInterface
import com.example.yesorno.domain.interfaces.repo.MessageRepoInterface
import com.example.yesorno.domain.services.factory.MainFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class) // or whatever graph fits your need the best
interface RepositoryModules {
    @Binds
    fun provideMessageRepositoryImpl(repository: MessageRepository): MessageRepoInterface

    @Binds
    fun provideMainFactoryRepositoryImpl(repository: MainFactory): MainFactoryInterface
}