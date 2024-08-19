package com.example.yesorno.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.yesorno.data.utils.ConstantsData
import com.example.yesorno.domain.models.MessageUIState
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao  {
    @Insert(MessageUIState::class,onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: MessageUIState)

    @Query("DELETE FROM ${ConstantsData.MESSAGE_ROOM_TABLE_NAME} where id =:id")
    suspend fun deleteItemById(id: String)

    @Query("SELECT * FROM ${ConstantsData.MESSAGE_ROOM_TABLE_NAME}")
    suspend fun getAllItems(): List<MessageUIState>

    @Query("SELECT * FROM ${ConstantsData.MESSAGE_ROOM_TABLE_NAME}")
    fun getAllItemsFlow(): Flow<List<MessageUIState>?>

    @Query("SELECT * FROM ${ConstantsData.MESSAGE_ROOM_TABLE_NAME} WHERE id =:idMain LIMIT 1")
    suspend fun getItemById(idMain : String): MessageUIState?

    @Query("delete from ${ConstantsData.MESSAGE_ROOM_TABLE_NAME}")
    suspend fun clear()

}