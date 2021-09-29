package com.example.livedatademo.transformationmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.livedatademo.R
import kotlinx.android.synthetic.main.activity_trans_map.*

class TransMapActivity : AppCompatActivity() {

    private val mapViewModel: TransMapViewModel by viewModels<TransMapViewModel> {
        ViewModelProvider.NewInstanceFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trans_map)
        mapViewModel.mapLiveData.observe(this, {
            tv_map.text = it
        })
        btn_map.setOnClickListener {
            mapViewModel.sendData()
        }
    }
}