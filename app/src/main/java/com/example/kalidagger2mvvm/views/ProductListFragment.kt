package com.example.kalidagger2mvvm.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.kalidagger2mvvm.FakerApplication
import com.example.kalidagger2mvvm.MainActivity
import com.example.kalidagger2mvvm.adapter.ProductListAdapter
import com.example.kalidagger2mvvm.databinding.FragmentDogsBreedListBinding
import com.example.kalidagger2mvvm.di.ApplicationComponent
import com.example.kalidagger2mvvm.models.Product
import com.example.kalidagger2mvvm.viewmodels.MainViewModel
import com.example.kalidagger2mvvm.viewmodels.MainViewModelFactory
import javax.inject.Inject

class ProductListFragment : Fragment() {

    private lateinit var binding: FragmentDogsBreedListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDogsBreedListBinding.inflate(layoutInflater, container, false)


        return binding.root
    }
}
