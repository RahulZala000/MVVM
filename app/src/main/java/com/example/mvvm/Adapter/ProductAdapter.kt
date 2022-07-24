package com.example.mvvm.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm.activity.MainActivity
import com.example.mvvm.Model.APIResponse
import com.example.mvvm.R
import com.example.mvvm.databinding.CardBinding

class ProductAdapter(var data: List<APIResponse>, var listner: MainActivity):RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.MyViewHolder {

         return MyViewHolder(CardBinding.inflate(LayoutInflater.from(parent.context),
             parent,
             false))
    }

    override fun onBindViewHolder(holder: ProductAdapter.MyViewHolder, position: Int) {
        var item=data[position]

        holder.binding.apply {

            Glide.with(img).load(item.url)
                .fitCenter()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(img)

            check.setOnClickListener {
                if(R.drawable.ic_baseline_check_circle.toString()==check.drawable.toString())
                        listner.favlist("Insert",item)
                else if(R.drawable.ic_baseline_check_circle_outline.toString()==check.drawable.toString())
                    listner.favlist("Remove",item)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(var binding: CardBinding) : RecyclerView.ViewHolder(binding.root)


    interface fav{
        fun favlist(temp:String,data:APIResponse)
    }
}