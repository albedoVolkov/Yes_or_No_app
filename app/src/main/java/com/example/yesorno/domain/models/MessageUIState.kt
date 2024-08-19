package com.example.yesorno.domain.models

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.yesorno.data.utils.ConstantsData
import com.google.gson.Gson
import java.util.Date

@Entity(tableName = ConstantsData.MESSAGE_ROOM_TABLE_NAME)
data class MessageUIState (
    @PrimaryKey
    @ColumnInfo("id")
    val id : String,
    @ColumnInfo("name")
    val name : String,
    @ColumnInfo("date")
    val date : Date,
    @ColumnInfo("data")
    val data : Bitmap,
    ){
        override fun toString(): String {
            return Gson().toJson(this,MessageUIState::class.java)
        }
    }
    fun fromStringToMessageUIState(string: String): MessageUIState? {
        return try {
            Gson().fromJson(string, MessageUIState::class.java)
        }catch(e : Exception){
            null
        }
    }