package com.example.pagacel.sdk.compatibility.orange_compatibility.models.responses

import com.google.gson.annotations.SerializedName


data class ValidateCompatibilityResponse (
    @SerializedName("status")
    var status:String,
    @SerializedName("message")
    var message: String,
    @SerializedName("model")
    var model: CompatibilityModel
)

data class CompatibilityModel(
    @SerializedName("imei")
    var imei: ImeiModel,
    @SerializedName("deviceFeatures")
    var deviceFeatures: DeviceFeaturesModel
)

data class ImeiModel(
    @SerializedName("imei")
    var imei:String,

    @SerializedName("homologated")
    var homologated:String,

    @SerializedName("blocked")
    var blocked:String,

    @SerializedName("sub_category")
    var sub_category:String,

    @SerializedName("soportaESIM")
    var soportaESIM:String,
)

data class DeviceFeaturesModel(
    @SerializedName("volteCapable")
    var volteCapable:String,

    @SerializedName("band28")
    var band28:String,

    @SerializedName("model")
    var model:String,

    @SerializedName("brand")
    var brand:String,

)