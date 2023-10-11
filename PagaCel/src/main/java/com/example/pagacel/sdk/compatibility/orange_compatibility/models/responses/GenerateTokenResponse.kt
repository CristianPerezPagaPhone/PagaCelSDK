package com.example.pagacel.sdk.compatibility.orange_compatibility.models.responses

import com.google.gson.annotations.SerializedName


data class GenerateTokenResponse (
    @SerializedName("status")
    var status:String,
    @SerializedName("message")
    var message: String,
    @SerializedName("token")
    var token: String
)
