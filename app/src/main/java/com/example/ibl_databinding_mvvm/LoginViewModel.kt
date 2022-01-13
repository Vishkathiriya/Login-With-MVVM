package com.example.ibl_databinding_mvvm

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var user: User = User()
    var onLoginResultCallbacks: OnLoginResultCallbacks? = null

    fun getEmailTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                user.email = p0.toString()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        }
    }

    fun getPasswordTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                user.password = p0.toString()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        }
    }

    fun onLoginClicked(view: View) {
        when (user.isValidation()) {
            0 -> onLoginResultCallbacks?.onError("Enter Email")
            1 -> onLoginResultCallbacks?.onError("Email Invalid")
            2 -> onLoginResultCallbacks?.onError("Password must be greater than 6")
            else -> onLoginResultCallbacks?.onSuccess("Login Success")
        }
    }

}