package com.example.yesorno.data.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.room.TypeConverter
import com.example.yesorno.domain.models.MessageUIState
import com.example.yesorno.domain.models.fromStringToMessageUIState
import com.google.gson.Gson
import java.io.ByteArrayOutputStream
import java.util.Date
import javax.inject.Inject

class ListTypeConverter @Inject constructor(){
    @TypeConverter
    fun fromStringListToString(value: List<String>): String {
        return value.joinToString(separator = "||,||")
    }
    @TypeConverter
    fun fromStringToStringList(value: String): List<String> {

        if (value == "" || value == "[]" || value == "null"){
            return listOf()
        }
        return value.split("||,||").map { it }
    }


    @TypeConverter
    fun fromStringToIntList(value: String): List<Int> {
        if (value == ""){
            return listOf()
        }
        return value.split("||,||").map { it.toInt() }
    }
    @TypeConverter
    fun fromIntListToString(value: List<Int>): String {
        return value.joinToString(separator = "||,||")
    }


    @TypeConverter
    fun fromDateToString(value: Date): String { return Gson().toJson(value, Date::class.java) }

    @TypeConverter
    fun fromStringToDate(value: String): Date { return Gson().fromJson(value, Date::class.java) }




    @TypeConverter
    fun fromMessageUIStateListToString(value: List<MessageUIState>): String {
        return value.joinToString(separator = "||,||")
    }
    @TypeConverter
    fun fromStringToMessageUIStateList(value: String): List<MessageUIState> {
        try{
            if (value == "" || value == "[]" || value == "null"){
                return listOf()
            }
            return value.split("||,||").map {
                fromStringToMessageUIState(it)!!
            }
        }catch (e : Exception){ return listOf() }
    }

    @TypeConverter
    fun fromBitmapToString(bitmap: Bitmap): String {
        try {
            val outputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT)
        }catch (e : Exception){
            return ""
        }
    }

    @TypeConverter
    fun fromStringToBitmap(value: String): Bitmap? {
        try {
            val decodedBytes: ByteArray = Base64.decode(value.substring(value.indexOf(",") + 1), Base64.DEFAULT)
            return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
        }catch (e : Exception){
            return null
        }
    }


}