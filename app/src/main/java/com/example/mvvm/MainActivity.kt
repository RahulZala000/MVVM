package com.example.mvvm

import android.app.Application
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.Adapter.ProductAdapter
import com.example.mvvm.Factory.ProdDataFactory
import com.example.mvvm.ViewModel.DataViewModel
import com.example.mvvm.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: DataViewModel

    @Inject
    lateinit var profac:ProdDataFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

   (application as ProductApplication).appcom.inject(this)

        viewModel=ViewModelProvider(this,profac).get(DataViewModel::class.java)




            viewModel.live?.observe(this, Observer {
                       binding.dataview.apply {
                            layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                            adapter=ProductAdapter(it)

                        }
              //  Log.d("@test", it.toString())
             //   binding.pro.text=it.joinToString { x-> x.title +"\n"+ x.desc }
                })
    }
}