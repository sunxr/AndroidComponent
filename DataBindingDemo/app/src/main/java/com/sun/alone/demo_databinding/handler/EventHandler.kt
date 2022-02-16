package com.sun.alone.demo_databinding.handler

import android.view.View
import android.widget.Toast
import com.sun.alone.demo_databinding.task.Task

class EventHandler {

  fun onClickFriend(view: View) {
    Toast.makeText(view.context, "onClickFriend", Toast.LENGTH_LONG).show()
  }

  fun onTaskClick(task: Task) {
    task.run()
  }

  fun onTaskClick(view: View, task: Task) {
    Toast.makeText(view.context, "onTaskClick", Toast.LENGTH_LONG).show()
    task.run()
  }

  fun onCompletedChanged(task: Task, completed: Boolean) {
    if (completed) {
      task.run()
    }
  }
}