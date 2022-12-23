package com.example.kalidagger2mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.kalidagger2mvvm.adapter.ProductListAdapter
import com.example.kalidagger2mvvm.databinding.ActivityMainBinding
import com.example.kalidagger2mvvm.models.Product
import com.example.kalidagger2mvvm.viewmodels.MainViewModel
import com.example.kalidagger2mvvm.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var mainViewModel: MainViewModel

    private val adapter = ProductListAdapter()

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      (application as FakerApplication).applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)
        binding.recycleView.adapter = adapter

        mainViewModel.productLiveData.observe(this) { dogslist ->
            setProducts(dogslist)
        }
    }

    private fun setProducts(productList: List<Product>) {
        binding.apply {
            binding.progressBar.visibility = View.GONE
            adapter.setData(productList)
        }

    }
}