package com.example.yesorno.domain.interfaces.factory

import android.graphics.Bitmap
import com.example.yesorno.domain.models.MessageUIState
import java.util.Date

interface MainFactoryInterface {
    suspend fun createNewMessageUIState(id : String, name: String, date: Date, data: Bitmap) : MessageUIState
}