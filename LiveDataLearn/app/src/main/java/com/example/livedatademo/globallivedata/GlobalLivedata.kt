package com.example.livedatademo.globallivedata

import androidx.lifecycle.LiveData

class GlobalLivedata : LiveData<String>() {

    val countDownManager = CountDownManager()
    val listener = object : OnDataChangeListener {
        override fun change(data: String) {
            postValue(data)
        }
    }

    override fun onActive() {
        super.onActive()
        countDownManager.setListener(listener)
    }

    override fun onInactive() {
        super.onInactive()
        countDownManager.removeListener(listener)
    }

    companion object {
        private lateinit var globalLivedata: GlobalLivedata
        fun getInstance(): GlobalLivedata {
            globalLivedata = if (::globalLivedata.isInitialized) globalLivedata else GlobalLivedata()
            return globalLivedata
        }
    }

}