package com.example.pagacel.sdk.compatibility.orange_compatibility.view.views

import com.example.pagacel.sdk.compatibility.orange_compatibility.models.responses.GenerateTokenResponse
import com.example.pagacel.sdk.compatibility.orange_compatibility.models.responses.ValidateCompatibilityResponse

interface CompatibilityDialogView {
    fun showDialog()
    fun hideDialog()
    fun showInformation(validateCompatibilityResponse: ValidateCompatibilityResponse)
    fun changeMessage(message: String)
    fun changeTitle(title: Int)
    fun changeTitle(title: String)
}