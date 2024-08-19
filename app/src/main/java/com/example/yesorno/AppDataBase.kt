package com.example.yesorno

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.yesorno.data.local.MessageDao
import com.example.yesorno.data.utils.ListTypeConverter
import com.example.yesorno.domain.models.MessageUIState
import dagger.hilt.android.qualifiers.ApplicationContext

@Database(entities = [MessageUIState::class, ], version = 1, exportSchema = true)
@TypeConverters(ListTypeConverter::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun messageDao(): MessageDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataBase(@ApplicationContext context: Context): AppDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "application_data_base"
                ).build()
                INSTANCE = instance
                return  instance
            }
        }
    }
}