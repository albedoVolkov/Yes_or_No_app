package com.example.yesorno.domain.services.factory

import android.graphics.Bitmap
import com.example.yesorno.domain.interfaces.factory.MainFactoryInterface
import com.example.yesorno.domain.models.MessageUIState
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainFactory @Inject constructor() : MainFactoryInterface {

    companion object {
        const val TAG = "MainFactory"
    }

    private var layoutId = "0"

    override suspend fun createNewMessageUIState(
        id : String,
        name: String,
        date: Date,
        data: Bitmap
    ) : MessageUIState{
        if(id != "-1") {
            layoutId = (layoutId.toInt() + 1).toString()
            return MessageUIState(
                layoutId,
                name,
                date,
                data
            )
        }else{
            return MessageUIState(
                id,
                name,
                date,
                data
            )
        }
    }

}