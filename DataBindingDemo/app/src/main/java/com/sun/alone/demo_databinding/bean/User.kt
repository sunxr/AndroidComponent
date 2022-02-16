package com.sun.alone.demo_databinding.bean

data class User(var firstName: String, var lastName: String) {
  override fun toString(): String {
    return "User{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}'
  }
}
