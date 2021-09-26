package com.example.livedatademo.countdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedatademo.R
import kotlinx.android.synthetic.main.activity_count_down.*

class CountDownActivity : AppCompatActivity() {

    val countDownModel: CountDownModel by viewModels<CountDownModel>() {
        ViewModelProvider.NewInstanceFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)
        countDownModel.countDownLiveData.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                t?.let { tv_countdown_remainsecond.text = it }
            }
        })
    }
}