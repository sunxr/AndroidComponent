package com.sun.alone.demo_databinding.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sun.alone.demo_databinding.R
import com.sun.alone.demo_databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
      clickListener = View.OnClickListener {  view ->
        var intent: Intent? = null
        when (view.id) {
          R.id.btn_base_use -> intent = Intent(this@MainActivity, BaseUseActivity::class.java)
          R.id.btn_layout_detail -> intent = Intent(this@MainActivity, LayoutDetailActivity::class.java)
          R.id.btn_custom_attribute -> intent = Intent(this@MainActivity, CustomAttributeActivity::class.java)
          R.id.btn_observable -> intent = Intent(this@MainActivity, ObservableActivity::class.java)
          R.id.btn_double_binding -> intent = Intent(this@MainActivity, DoubleBindingActivity::class.java)
        }
        intent?.let {
          startActivity(it)
        }
      }
    }
  }
}