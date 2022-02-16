package com.sun.alone.demo_databinding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sun.alone.demo_databinding.BR
import com.sun.alone.demo_databinding.R
import com.sun.alone.demo_databinding.bean.RecyclerViewItem
import com.sun.alone.demo_databinding.databinding.AdapterRecyclerViewBinding

class RecyclerViewAdapter(private var list: List<RecyclerViewItem>) : RecyclerView.Adapter<RecyclerViewAdapter.BindingHolder>() {

  var mList: List<RecyclerViewItem>? = list

  inner class BindingHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var binding:AdapterRecyclerViewBinding? = null
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
    val binding = DataBindingUtil.inflate<AdapterRecyclerViewBinding>(
      LayoutInflater.from(parent.context), R.layout.adapter_recycler_view, parent, false)
    val holder = BindingHolder(binding.root)
    holder.binding = binding
    return holder
  }

  override fun onBindViewHolder(holder: BindingHolder, position: Int) {
    holder.binding?.setVariable(BR.item, mList?.get(position))
    holder.binding?.executePendingBindings()
  }

  override fun getItemCount(): Int {
    return mList?.size ?: 0
  }
}