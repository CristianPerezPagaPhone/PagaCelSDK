package com.example.pagacel.sdk.compatibility.orange_compatibility.models.requests

import com.google.gson.annotations.SerializedName


data class GenerateTokenRequest (
    @SerializedName("user")
    var user:String,
    @SerializedName("password")
    var password: String,
)
