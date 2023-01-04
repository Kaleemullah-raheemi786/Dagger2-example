package com.example.kalidagger2mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kalidagger2mvvm.databinding.ItemLayoutBinding
import com.example.kalidagger2mvvm.models.Product
import com.squareup.picasso.Picasso

class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ListViewHolder>(){

    private lateinit var onItemClickCallback: OnItemClickCallback
    private val listProduct = ArrayList<Product>()

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setData(poke: List<Product>){
        listProduct.clear()
        listProduct.addAll(poke)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(private var binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product){

            binding.apply{
          Picasso.get().load(product.image).into(image)
                name.text = product.title
                price.text = product.price.toString()
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding =
            ItemLayoutBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    interface OnItemClickCallback {
        fun onItemClicked(product: Product)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listProduct[position])
    }

    override fun getItemCount(): Int = listProduct.size

}