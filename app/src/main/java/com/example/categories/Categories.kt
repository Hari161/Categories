package com.example.categories

import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.categories.adapter.CategoryAdapter
import com.example.categories.repository.Repository
import com.example.categories.response.MainResponse
import kotlinx.android.synthetic.main.activity_categories.*

class Categories : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private var responseImage: MainResponse? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        if(checkNet())
          setValue()
        else
            dbRetrive()

    }

    override fun onResume() {
        super.onResume()
        if(checkNet())
            setValue()
        else
            dbRetrive()
    }

    private fun dbRetrive() {
        Toast.makeText(this, "No Internet Access", Toast.LENGTH_LONG).show()
    }

    private fun checkNet(): Boolean {
        val connectivityManager = this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!.isConnected;
    }

    private fun setValue() {
        viewModel.getCustomPosts()
        viewModel.myCustomPosts.observe(this, Observer { response ->
            if (response.isSuccessful) {
                responseImage = response.body()
                response.body()?.let { setcategoryrList(it) }
                Log.d("check resp", response.body().toString())
            } else {
                Toast.makeText(this, "failed", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setcategoryrList(resp: MainResponse) {
        main_rc.layoutManager = LinearLayoutManager(this)
        val adapter = CategoryAdapter(resp.categories,this)
        main_rc.adapter = adapter
        main_rc.adapter?.notifyDataSetChanged()
    }


}