package com.example.livedatademo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.livedatademo.countdown.CountDownActivity
import com.example.livedatademo.globallivedata.NotifyGlobalDataWithLivedataActivity
import com.example.livedatademo.transformationmap.TransMapActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_tocountdown.setOnClickListener {
            startActivity(Intent(this, CountDownActivity::class.java))
        }
        btn_toglobaldatanotify.setOnClickListener {
            startActivity(Intent(this, NotifyGlobalDataWithLivedataActivity::class.java))
        }
        btn_transformation_map.setOnClickListener {
            startActivity(Intent(this, TransMapActivity::class.java))
        }
    }
}