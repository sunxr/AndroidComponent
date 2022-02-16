package com.sun.alone.demo_databinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sun.alone.demo_databinding.R
import com.sun.alone.demo_databinding.bean.User
import com.sun.alone.demo_databinding.databinding.ActivityLayoutDetailBinding

class LayoutDetailActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val myUser = User("ronghua", "xiehou")
    val myUserList = mutableListOf<User>()
    myUserList.add(myUser)
    myUserList.add(User("空谷", "幽兰"))

    DataBindingUtil.setContentView<ActivityLayoutDetailBinding>(this, R.layout.activity_layout_detail).apply {
      user = myUser
      userList = myUserList
      position = 1
    }
  }
}