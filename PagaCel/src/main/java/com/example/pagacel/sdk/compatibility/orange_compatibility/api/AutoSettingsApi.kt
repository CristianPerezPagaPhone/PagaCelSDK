package com.example.pagacel.sdk.compatibility.orange_compatibility.api

import com.example.pagacel.sdk.compatibility.orange_compatibility.models.requests.GenerateTokenRequest
import com.example.pagacel.sdk.compatibility.orange_compatibility.models.requests.GetLineStatusRequest
import com.example.pagacel.sdk.compatibility.orange_compatibility.models.requests.ValidateCompatibilityRequest
import com.example.pagacel.sdk.compatibility.orange_compatibility.models.responses.GenerateTokenResponse
import com.example.pagacel.sdk.compatibility.orange_compatibility.models.responses.GetLineStatusResponse
import com.example.pagacel.sdk.compatibility.orange_compatibility.models.responses.ValidateCompatibilityResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AutoSettingsApi {

    @POST("line/validateCompatibility/")
    suspend fun validateCompatibility(@Body request: ValidateCompatibilityRequest): ValidateCompatibilityResponse

    @POST("line/getStatusMsisdn/")
    suspend fun getLineStatus(@Body request: GetLineStatusRequest): GetLineStatusResponse

    @POST("token/generateToken/")
    suspend fun generateToken(@Body user: GenerateTokenRequest): GenerateTokenResponse
}