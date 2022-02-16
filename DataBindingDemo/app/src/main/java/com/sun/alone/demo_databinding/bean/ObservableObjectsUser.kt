package com.sun.alone.demo_databinding.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sun.alone.demo_databinding.BR

class ObservableObjectsUser() : BaseObservable() {

  constructor(firstName: String, lastName: String) : this(){
    this.firstName = firstName
    this.lastName = lastName
  }

  var firstName: String? = ""
    set(value) {
      field = value
      notifyPropertyChanged(BR.firstName)
    }
    @Bindable
    get() {
      return field ?: ""
    }

  var lastName: String? = ""
    set(value) {
      field = value
      notifyPropertyChanged(BR.lastName)
    }
    @Bindable
    get() {
      return field ?: ""
    }

}
