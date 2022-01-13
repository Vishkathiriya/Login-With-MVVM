package com.example.ibl_databinding_mvvm

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.ibl_databinding_mvvm.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    var viewModel: LoginViewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this)[LoginViewModel::class.java]
        binding.viewModel = viewModel

        viewModel.onLoginResultCallbacks = object : OnLoginResultCallbacks {
            override fun onSuccess(message: String) {
                Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
            }

            override fun onError(message: String) {
                Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
            }
        }
    }


}