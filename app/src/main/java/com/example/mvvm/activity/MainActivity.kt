package com.example.mvvm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.Adapter.ProductAdapter
import com.example.mvvm.Factory.ProdDataFactory
import com.example.mvvm.Model.APIResponse
import com.example.mvvm.ProductApplication
import com.example.mvvm.ViewModel.DataViewModel
import com.example.mvvm.databinding.ActivityMainBinding
import javax.inject.Inject


class MainActivity : AppCompatActivity() ,ProductAdapter.fav{

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: DataViewModel

    @Inject
    lateinit var profac:ProdDataFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

   (application as ProductApplication).appcom.inject(this)

       supportActionBar!!.title="HOME"// actionBar!!.title="HOME"

        viewModel=ViewModelProvider(this,profac).get(DataViewModel::class.java)


        viewModel.live.observe(this, Observer {
            binding.dataview.apply {
                layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                adapter=ProductAdapter(it,this@MainActivity)

            }
        })
    }

    override fun favlist(temp: String, data: APIResponse) {

    }
}