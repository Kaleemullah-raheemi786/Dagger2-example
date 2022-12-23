package com.example.kalidagger2mvvm.di

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.kalidagger2mvvm.MainActivity
import com.example.kalidagger2mvvm.databinding.FragmentDogsBreedListBinding
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}