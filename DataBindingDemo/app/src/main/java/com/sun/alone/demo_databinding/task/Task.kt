package com.sun.alone.demo_databinding.task

import android.util.Log

class Task : Runnable {

  companion object {
    @JvmStatic
    val TAG = "Task"
  }

  override fun run() {
    Log.i(TAG, "Task Running")
  }
}