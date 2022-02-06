package com.example.categories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.categories.repository.Repository
import com.example.categories.response.MainResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel (private val repository: Repository) : ViewModel() {

    var myCustomPosts: MutableLiveData<Response<MainResponse>> = MutableLiveData()

    fun getCustomPosts() {
        viewModelScope.launch {
            val response = repository.getCustomPosts()
            myCustomPosts.postValue(response)
        }
    }

}