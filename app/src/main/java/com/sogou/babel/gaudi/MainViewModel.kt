package com.sogou.babel.gaudi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _firstName = MutableLiveData("Hello")

    private val _secondName = MutableLiveData("World")
    private val _likeTimes = MutableLiveData(0)


    val firstName: LiveData<String> = _firstName
    val secondName: LiveData<String> = _secondName

    var likeTimes: LiveData<Int> = _likeTimes
        private set

    fun onLike() {
        _likeTimes.value = (_likeTimes.value ?: 0) + 1
    }

    val popularity: LiveData<Popularity> = Transformations.map(_likeTimes) {
        when {
            it > 9 -> Popularity.STAR
            it > 4 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }
    }

}

enum class Popularity {
    STAR, POPULAR, NORMAL
}
