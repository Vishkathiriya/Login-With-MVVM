package com.example.ibl_databinding_mvvm

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable

class User : BaseObservable() {
    var email: String = ""
    var password: String = ""

    fun isValidation(): Int {
        return when {
            TextUtils.isEmpty(email) -> 0
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> 1
            password.length <= 6 -> 2
            else -> -1
        }
    }
}