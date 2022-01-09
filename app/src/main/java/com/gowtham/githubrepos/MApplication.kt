package com.gowtham.githubrepos

import android.app.Application
import com.gowtham.core.Logger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MApplication : Application() {

    override fun onCreate() {
        super.onCreate()

    }
}
