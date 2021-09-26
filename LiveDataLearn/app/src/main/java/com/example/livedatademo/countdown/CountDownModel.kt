package com.example.livedatademo.countdown

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountDownModel : ViewModel() {

    val countDownLiveData = MutableLiveData<String>()
    private var remainSecond = 2000

    init {
        val countDown = object : CountDownTimer(2000 * 1000, 1000) {
            override fun onTick(p0: Long) {
                remainSecond--
                countDownLiveData.postValue("剩余：${remainSecond} 秒")
            }

            override fun onFinish() {
                countDownLiveData.postValue("倒计时结束")
            }
        }
        countDown.start()
    }
}