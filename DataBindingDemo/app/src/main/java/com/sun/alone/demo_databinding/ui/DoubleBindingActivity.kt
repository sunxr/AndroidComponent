package com.sun.alone.demo_databinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sun.alone.demo_databinding.R
import com.sun.alone.demo_databinding.bean.ObservableObjectsUser
import com.sun.alone.demo_databinding.databinding.ActivityDoubleBindingBinding

class DoubleBindingActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    DataBindingUtil.setContentView<ActivityDoubleBindingBinding>(this, R.layout.activity_double_binding).apply {
      user = ObservableObjectsUser()
    }
  }
}