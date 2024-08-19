package com.example.yesorno.domain.interfaces.repo

import com.example.yesorno.domain.models.MessageUIState
import kotlinx.coroutines.flow.Flow

interface MessageRepoInterface  {

    suspend fun insert(data: MessageUIState): Result<Boolean?>
    suspend fun delete(id: String): Result<Boolean?>
    suspend fun update(data: MessageUIState): Result<Boolean?>

    suspend fun getList(): Result<List<MessageUIState>?>
    fun getListFlow(): Flow<List<MessageUIState>?>

    suspend fun getById(id : String) : Result<MessageUIState?>
}