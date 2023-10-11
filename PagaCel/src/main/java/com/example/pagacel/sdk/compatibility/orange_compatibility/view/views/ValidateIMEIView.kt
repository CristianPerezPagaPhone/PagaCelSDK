package com.example.pagacel.sdk.compatibility.orange_compatibility.view.views

import com.example.pagacel.sdk.compatibility.orange_compatibility.models.responses.ValidateCompatibilityResponse


interface ValidateIMEIView {
    fun onValidInputs()
    fun onInvalidInput()
    fun onValidIMEI(): ValidateCompatibilityResponse
    fun onInvalidIMEI()
    fun showLoading()
    fun hideLoading()
}