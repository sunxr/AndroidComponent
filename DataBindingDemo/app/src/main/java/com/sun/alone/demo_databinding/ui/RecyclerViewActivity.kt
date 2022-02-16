package com.sun.alone.demo_databinding.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sun.alone.demo_databinding.R
import com.sun.alone.demo_databinding.adapter.RecyclerViewAdapter
import com.sun.alone.demo_databinding.bean.RecyclerViewItem
import com.sun.alone.demo_databinding.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

  private var list: MutableList<RecyclerViewItem>? = ArrayList<RecyclerViewItem>()

  @SuppressLint("NotifyDataSetChanged")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initData()

    DataBindingUtil.setContentView<ActivityRecyclerViewBinding>(this, R.layout.activity_recycler_view).apply {
      recyclerView.layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
      val recyclerViewAdapter: RecyclerViewAdapter? = list?.let { RecyclerViewAdapter(it) }
      recyclerView.adapter = recyclerViewAdapter
      updateData()
      recyclerViewAdapter?.notifyDataSetChanged()
    }
  }

  private fun initData() {
    for (i in 0..9) {
      list?.add(RecyclerViewItem(i.toString()))
    }
  }

  private fun updateData() {
    for (i in 10..19) {
      list?.add(RecyclerViewItem(i.toString()))
    }
  }
}