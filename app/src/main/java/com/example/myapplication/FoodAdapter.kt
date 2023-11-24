package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemFoodsBinding
import models.FoodModel

class FoodAdapter(
private val foodInterface: FoodInterface
):RecyclerView.Adapter<FoodAdapter.FoodViewHoldor>() {

    fun updateList(movioList: List<FoodModel>){
        foodList.clear()
        foodList.addAll(movioList)
        notifyDataSetChanged()
    }

    val foodList = mutableListOf<FoodModel>()

    inner class FoodViewHoldor(
        private val binding: ItemFoodsBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(foodModel: FoodModel) {
            binding.foodVactor.setOnClickListener{
                foodInterface.interfaceFood()
            }
            binding.firstFoodTv.text = foodModel.name
            binding.secondFoodTv.text = foodModel.name_burger
            binding.thirdFoodTv.text = foodModel.name_pizza
            Glide.
            with(binding.root)
                .load(foodModel.img)
                .into(binding.foodPizza)
            binding

        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodViewHoldor {
        val binding = ItemFoodsBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_foods,
                parent,
                false
            )
        )
        return FoodViewHoldor(binding)
    }

    override fun getItemCount(): Int = foodList.size

    override fun onBindViewHolder(
        holder: FoodViewHoldor,
        position: Int,
        ) {holder.bind(foodList[position])
    }
}