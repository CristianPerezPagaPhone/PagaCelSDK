package com.example.pagacel.sdk.utils.views.common

interface SimpleDialog {
    fun showDialog()
    fun hideDialog()
    fun changeMessage(message: Int)
    fun changeMessage(message: String)
    fun changeTitle(title: Int)
    fun changeTitle(title: String)
}