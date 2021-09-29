package com.example.livedatademo.transformationmap

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

data class User(var name:String, var age:Int)

class TransMapViewModel: ViewModel() {

    val userLiveData = MutableLiveData<User>()
    val mapLiveData = Transformations.map(userLiveData) {
        "${it.name} : ${it.age}"
    }

    fun sendData() {
        userLiveData.value = User("李白",1200)
    }
}