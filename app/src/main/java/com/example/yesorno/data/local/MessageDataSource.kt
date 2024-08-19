package com.example.yesorno.data.local

import com.example.yesorno.domain.models.MessageUIState
import kotlinx.coroutines.flow.Flow

interface MessageDataSource {

        suspend fun getListItems(): Result<List<MessageUIState>?>
        fun getListItemsFlow(): Flow<List<MessageUIState>?>

        suspend fun getItemById(id : String) : Result<MessageUIState?>

        suspend fun addItem(item : MessageUIState) : Result<Boolean?>

        suspend fun deleteItem(id : String) : Result<Boolean?>

        suspend fun deleteAllItems(): Result<Boolean?>

}