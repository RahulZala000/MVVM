package com.example.mvvm.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.adapters.AdapterViewBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm.Model.ProductModel
import com.example.mvvm.R
import kotlinx.coroutines.delay

class ProductAdapter(var prodlist:List<ProductModel>):RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.MyViewHolder {

         return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false))
    }

    override fun onBindViewHolder(holder: ProductAdapter.MyViewHolder, position: Int) {
        holder.data(prodlist[position])
    }

    override fun getItemCount(): Int {
        return prodlist.size
    }

    class MyViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)
    {
        var img:ImageView=itemView.findViewById(R.id.img)
        var p:TextView=itemView.findViewById(R.id.price)
        var id:TextView=itemView.findViewById(R.id.id)
        var d:TextView=itemView.findViewById(R.id.desc)
        var title:TextView=itemView.findViewById(R.id.title)

        fun data(get:ProductModel)
        {

            id.text="ID : "+get.id.toString()
            title.text="TITLE :"+get.title
            d.text="DESC :"+get.description
            p.text="PRICE :"+get.price.toString()

            Glide.with(img).load(get.image)
                .fitCenter()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(img)
        }

    }
}