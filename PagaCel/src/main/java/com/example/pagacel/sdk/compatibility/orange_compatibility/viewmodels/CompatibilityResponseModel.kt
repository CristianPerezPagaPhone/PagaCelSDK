/*
 * FavouriteBeneficiary.kt - app
 * Created by JMORA on 6/23/20 2:09 AM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20 2:09 AM
 */

package com.pagaphone.android.features.orange.compatibility.models

import org.json.JSONObject

data class CompatibilityResponseModel(
    val modelo: modelo,
    val mensaje: String,
    val estatus: Int
)

data class modelo(
    val imei: imei,
    val deviceFeatures: deviceFeatures
)

data class imei(
    val imei : String,
    val homologated : String,
    val blocked : String
)

data class deviceFeatures(
    val volteCapable : String,
    val band28 : String,
    val model : String,
    val brand : String
)