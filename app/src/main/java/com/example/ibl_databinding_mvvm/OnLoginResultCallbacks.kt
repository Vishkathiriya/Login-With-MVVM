package com.example.ibl_databinding_mvvm

interface OnLoginResultCallbacks {
    fun onSuccess(message: String)
    fun onError(message: String)
}