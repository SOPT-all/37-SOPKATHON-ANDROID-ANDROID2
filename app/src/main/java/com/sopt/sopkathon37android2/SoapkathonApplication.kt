package com.sopt.sopkathon37android2

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.sopkathon37android2.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class SoapkathonApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        initTimber()
        setNightMode()
    }
    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    private fun setNightMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
}
