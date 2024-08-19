package com.example.yesorno.di

import android.content.Context
import com.example.yesorno.AppDataBase
import com.example.yesorno.data.local.MessageDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDataBase {
        return AppDataBase.getDataBase(context)
    }

    @Provides
    fun provideMessagesDao(appDatabase: AppDataBase): MessageDao {
        return appDatabase.messageDao()
    }


}