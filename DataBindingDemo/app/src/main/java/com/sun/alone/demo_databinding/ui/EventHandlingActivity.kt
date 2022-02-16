package com.sun.alone.demo_databinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sun.alone.demo_databinding.R
import com.sun.alone.demo_databinding.databinding.ActivityEventHandlingBinding
import com.sun.alone.demo_databinding.handler.EventHandler
import com.sun.alone.demo_databinding.task.Task

class EventHandlingActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DataBindingUtil.setContentView<ActivityEventHandlingBinding>(this, R.layout.activity_event_handling).apply {
      handler = EventHandler()
      task = Task()
    }
  }
}