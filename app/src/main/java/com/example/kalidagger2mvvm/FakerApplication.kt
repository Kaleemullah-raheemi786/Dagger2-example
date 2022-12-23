package com.example.kalidagger2mvvm

import android.app.Application
import com.example.kalidagger2mvvm.di.ApplicationComponent
import com.example.kalidagger2mvvm.di.DaggerApplicationComponent

class FakerApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}