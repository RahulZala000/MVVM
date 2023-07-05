package com.example.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.Adapter.ProductAdapter
import com.example.mvvm.ViewModel.DataViewModel
import com.example.mvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel= ViewModelProvider(this)[DataViewModel::class.java]




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