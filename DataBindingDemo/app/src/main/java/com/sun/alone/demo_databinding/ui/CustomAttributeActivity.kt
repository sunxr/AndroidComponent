package com.sun.alone.demo_databinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sun.alone.demo_databinding.R
import com.sun.alone.demo_databinding.databinding.ActivityCustomAttributeBinding

class CustomAttributeActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    DataBindingUtil.setContentView<ActivityCustomAttributeBinding>(this, R.layout.activity_custom_attribute).let {
      it.url = "https://www.niwoxuexi.com/statics/images/nougat_bg.png"
    }
  }
}