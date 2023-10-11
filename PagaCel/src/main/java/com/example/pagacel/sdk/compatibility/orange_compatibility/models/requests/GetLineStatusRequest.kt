package com.example.pagacel.sdk.compatibility.orange_compatibility.models.requests

import com.google.gson.annotations.SerializedName


data class GetLineStatusRequest (
    @SerializedName("msisdn")
    var msisdn:String,
)
