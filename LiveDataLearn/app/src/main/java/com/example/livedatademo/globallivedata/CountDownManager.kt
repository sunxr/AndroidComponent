package com.example.livedatademo.globallivedata

import android.os.CountDownTimer

class CountDownManager {

    private var remainSecond = 2000;
    private val listeners = mutableListOf<OnDataChangeListener>()

    init {
        val countDown = object : CountDownTimer(2000 * 1000, 1000) {
            override fun onTick(p0: Long) {
                remainSecond--
                callback("剩余 ${remainSecond} 秒")
            }

            override fun onFinish() {
                callback("倒计时结束")
            }
        }
        countDown.start()
    }

    private fun callback(msg:String) {
        for (listener in listeners) {
            listener.change(msg)
        }
    }

    fun setListener(listener: OnDataChangeListener) {
        listeners.add(listener)
    }

    fun removeListener(listener: OnDataChangeListener) {
        listeners.remove(listener)
    }

}

interface OnDataChangeListener {
    fun change(data: String)
}