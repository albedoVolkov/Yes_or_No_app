package com.example.yesorno.domain.usecases.factory

import android.graphics.Bitmap
import com.example.yesorno.domain.interfaces.factory.MainFactoryInterface
import com.example.yesorno.domain.models.MessageUIState
import java.util.Date
import javax.inject.Inject

class CreateNewMessageUseCase @Inject constructor(private val factory : MainFactoryInterface) {
    suspend fun execute(name : String, date : Date, data : Bitmap, id: String = "-1") : MessageUIState {
        return factory.createNewMessageUIState(id,name,date,data)
    }
}