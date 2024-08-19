package com.example.yesorno

import android.app.Application
import androidx.work.Configuration
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App @Inject constructor() : Application(), Configuration.Provider {

    override val workManagerConfiguration: Configuration
        get() = Configuration
            .Builder()
            .setMinimumLoggingLevel(Log.ERROR)
            .build()

}