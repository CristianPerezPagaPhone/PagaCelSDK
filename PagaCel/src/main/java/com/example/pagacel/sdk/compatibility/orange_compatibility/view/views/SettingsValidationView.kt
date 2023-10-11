package com.example.pagacel.sdk.compatibility.orange_compatibility.view.views

import com.example.pagacel.sdk.compatibility.orange_compatibility.models.responses.GetLineStatusModel
import com.example.pagacel.sdk.compatibility.orange_compatibility.models.responses.GetLineStatusResponse


interface SettingsValidationView {
    fun showPlanInfo(lineResponse: GetLineStatusResponse)
    fun showPlanErrorInfo(message:String)
    fun showValidationOfLine()
    fun onTutorialBack()
}