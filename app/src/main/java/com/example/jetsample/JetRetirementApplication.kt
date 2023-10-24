package com.example.jetsample

import android.app.Application
import com.example.jetsample.Constant.APP_CENTER_SECRET_KEY
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class JetRetirementApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCenter.start(this, APP_CENTER_SECRET_KEY, Analytics::class.java, Crashes::class.java)
    }
}