package com.example.yesorno.data.repositories

import android.util.Log
import com.example.yesorno.data.local.MessageLocalDataSource
import com.example.yesorno.domain.interfaces.repo.MessageRepoInterface
import com.example.yesorno.domain.models.MessageUIState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MessageRepository  @Inject constructor(
    private val localSource: MessageLocalDataSource
) : MessageRepoInterface {

    private val TAG = "MessageRepository"


    override suspend fun insert(data: MessageUIState): Result<Boolean?> {
        val res = localSource.addItem(data)
        Log.d(TAG, "insert : data = $data : result = ${res.getOrNull()}")
        return res
    }


    override suspend fun delete(id: String): Result<Boolean?> {
        if (id != "" && id != "-1") {
            val oldItem = getById(id)

            if (oldItem.isSuccess && oldItem.getOrNull() != null) {
                val res = localSource.deleteItem(id)
                Log.d(TAG, "delete : id = $id : result = ${res.getOrNull()}")
                return res

            }else{ return Result.success(false) }

        }else{ return Result.success(false) }
    }

    override suspend fun update(data: MessageUIState): Result<Boolean?>{
        val oldItem = getById(data.id)

        if (oldItem.isSuccess && oldItem.getOrNull() != null) {
            val resDelete = localSource.deleteItem(data.id)
            if(resDelete.isSuccess){
                val resAdd = localSource.addItem(data)
                Log.d(TAG, "update : data = $data : result = ${resAdd.getOrNull()}")
                return resAdd
            }else{ return Result.success(false) }
        }else{ return Result.success(false) }
    }


    override suspend fun getList(): Result<List<MessageUIState>?> {
        val list = localSource.getListItems()
        Log.d(TAG, "getList : isSuccess = ${list.isSuccess} : result = ${list.getOrNull()}")
        return list
    }


    override fun getListFlow(): Flow<List<MessageUIState>?> = localSource.getListItemsFlow()


    override suspend fun getById(id : String) : Result<MessageUIState?>   {
        val item = localSource.getItemById(id)
        Log.d(TAG, "getById : isSuccess = ${item.isSuccess} : result = ${item.getOrNull()}")
        return item
    }

}