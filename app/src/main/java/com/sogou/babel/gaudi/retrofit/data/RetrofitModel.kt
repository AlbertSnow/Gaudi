package com.sogou.babel.gaudi.retrofit.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RetrofitModel : ViewModel() {

    private val _name = MutableLiveData("Albert")
    val name: LiveData<String>
        get() = _name

    private val _age = MutableLiveData<Int>(10)
    val age: LiveData<Int>
        get() = _age

    fun updateInfor() {
        viewModelScope.launch {
            val response = getMyResponse()
            _name.value = response.body()?.name
            _age.value = response.body()?.age
        }
    }

}