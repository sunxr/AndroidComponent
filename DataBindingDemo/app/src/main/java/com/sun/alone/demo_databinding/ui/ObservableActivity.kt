package com.sun.alone.demo_databinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sun.alone.demo_databinding.R
import com.sun.alone.demo_databinding.bean.ObservableObjectsUser
import com.sun.alone.demo_databinding.databinding.ActivityObservableBinding

class ObservableActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val obUser = ObservableObjectsUser("木子", "雪婷")

    DataBindingUtil.setContentView<ActivityObservableBinding>(this, R.layout.activity_observable).apply {
      user = obUser
      clickListener = View.OnClickListener {
        obUser.firstName = "子小"
        obUser.lastName = "昕荣"
      }
    }
  }
}