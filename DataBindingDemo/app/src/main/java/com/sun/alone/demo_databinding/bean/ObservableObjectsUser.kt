package com.sun.alone.demo_databinding.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sun.alone.demo_databinding.BR

class ObservableObjectsUser(firstName: String, lastName: String) : BaseObservable() {

  var firstName: String? = firstName
    set(value) {
      field = value
      notifyPropertyChanged(BR.firstName)
    }
    @Bindable
    get() {
      return field ?: ""
    }

  var lastName: String? = lastName
    set(value) {
      field = value
      notifyPropertyChanged(BR.lastName)
    }
    @Bindable
    get() {
      return field ?: ""
    }

}
