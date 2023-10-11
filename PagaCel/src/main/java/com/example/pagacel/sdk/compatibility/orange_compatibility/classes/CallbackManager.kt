package com.example.pagacel.sdk.compatibility.orange_compatibility.classes

import com.example.pagacel.sdk.compatibility.orange_compatibility.view.views.SettingsValidationView

object CallbackManager {
    private var miCallback: SettingsValidationView? = null

    fun setCallback(callback: SettingsValidationView) {
        miCallback = callback
    }

    fun getCallback(): SettingsValidationView? {
        return miCallback
    }
}
