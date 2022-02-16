package com.sun.alone.demo_databinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sun.alone.demo_databinding.R
import com.sun.alone.demo_databinding.bean.User
import com.sun.alone.demo_databinding.databinding.ActivityBaseUseBinding

class BaseUseActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val myUser = User("木子", "雪婷")

    DataBindingUtil.setContentView<ActivityBaseUseBinding>(this, R.layout.activity_base_use).apply {
      user = myUser
      clickListener = View.OnClickListener {
        myUser.firstName = "子小"
        myUser.lastName = "昕荣"
      }
    }
  }
}