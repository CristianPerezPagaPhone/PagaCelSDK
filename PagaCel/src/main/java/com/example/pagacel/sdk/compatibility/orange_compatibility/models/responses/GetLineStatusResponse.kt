/*
 * FavouriteBeneficiary.kt - app
 * Created by JMORA on 6/23/20 2:09 AM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20 2:09 AM
 */

package com.example.pagacel.sdk.compatibility.orange_compatibility.models.responses

import com.google.gson.annotations.SerializedName

//import com.google.gson.annotations.SerializedName

data class GetLineStatusResponse(
    @SerializedName("status")
    var status: Int,

    @SerializedName("message")
    var message: String,
    @SerializedName("model")
    var model: GetLineStatusModel?,

)

data class GetLineStatusModel(
    @SerializedName("information")
    var information: GetLineInformation,

    @SerializedName("status")
    var status: GetLineStatus,

    @SerializedName("primaryOffering")
    var primaryOffering: GetLinePrimaryOffering,

    @SerializedName("offers")
    var offers: List<GetLinePrimaryOffers>,

    @SerializedName("mvnoInformation")
    var mvnoInformation: GetLineMvnoInformation,

    @SerializedName("currentOffert")
    var currentOffert: GetLineCurrentOffert,
)
data class GetLineInformation(
    @SerializedName("idSubscriber")
    var idSubscriber: String?,

    @SerializedName("IMSI")
    var IMSI: String?,

    @SerializedName("ICCID")
    var ICCID: String?,

    @SerializedName("IMEI")
    var IMEI: String?,

    @SerializedName("coordinates")
    var coordinates: String?,
)
data class GetLineStatus(
    @SerializedName("subStatus")
    var subStatus: String?,
    @SerializedName("reasonCode")
    var reasonCode: String?,
)
data class GetLinePrimaryOffering(
    @SerializedName("idOffer")
    var idOffer: Int?,
    @SerializedName("offer")
    var offer: String?,
)

data class GetLinePrimaryOffers(
    @SerializedName("name")
    var name: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("totalAmt")
    var totalAmt: String?,
    @SerializedName("unusedAmt")
    var unusedAmt: String?,
    @SerializedName("expireDate")
    var expireDate: String?,
    @SerializedName("effectiveDate")
    var effectiveDate: String?,
    @SerializedName("idAltan")
    var idAltan: String?,
)

data class GetLineMvnoInformation(

    @SerializedName("operatorName")
    var operatorName: String?,
    @SerializedName("operatorLogo")
    var operatorLogo: String?,
)

data class GetLineCurrentOffert(
    @SerializedName("idOffer")
    var idOffer: Int?,
    @SerializedName("offer")
    var offer: String?,
    @SerializedName("expireDate")
    var expireDate: String?,
    @SerializedName("effectiveDate")
    var effectiveDate: String?,
    @SerializedName("individualCycleTime")
    var individualCycleTime: Int?,

    @SerializedName("diasTranscurridos")
    var diasTranscurridos: Int?,
    @SerializedName("fechaInicio")
    var fechaInicio: String?,
    @SerializedName("diasPorTranscurrir")
    var diasPorTranscurrir: Int?,
    @SerializedName("fechaFin")
    var fechaFin: String?,

    @SerializedName("datos")
    var datos: GetLineDatos?,
    @SerializedName("datosRoaming")
    var datosRoaming: GetLineRoaming?,
    @SerializedName("minutos")
    var minutos: GetLineMinutos?,
    @SerializedName("smsNacionales")
    var smsNacionales: GetLineSmsNacionales?,
    @SerializedName("minutosRoaming")
    var minutosRoaming: GetLineMinutosRoaming?,
    @SerializedName("smsRoaming")
    var smsRoaming: GetLineSmsRoaming?,

)

data class GetLineDatos(
    @SerializedName("totales")
    var totales: Int?,
    @SerializedName("disponibles")
    var disponibles: Int?,
    @SerializedName("consumidos")
    var consumidos: Int?,
)

data class GetLineRoaming(
    @SerializedName("totales")
    var totales: Int?,
    @SerializedName("disponibles")
    var disponibles: Int?,
    @SerializedName("consumidos")
    var consumidos: Int?,
)
data class GetLineMinutos(
    @SerializedName("totales")
    var totales: Int?,
    @SerializedName("disponibles")
    var disponibles: Int?,
    @SerializedName("consumidos")
    var consumidos: Int?,
)

data class GetLineSmsNacionales(
    @SerializedName("totales")
    var totales: Int?,
    @SerializedName("disponibles")
    var disponibles: Int?,
    @SerializedName("consumidos")
    var consumidos: Int?,
)

data class GetLineMinutosRoaming(
    @SerializedName("totales")
    var totales: Int?,
    @SerializedName("disponibles")
    var disponibles: Int?,
    @SerializedName("consumidos")
    var consumidos: Int?,
)

data class GetLineSmsRoaming(
    @SerializedName("totales")
    var totales: Int?,
    @SerializedName("disponibles")
    var disponibles: Int?,
    @SerializedName("consumidos")
    var consumidos: Int?,
)