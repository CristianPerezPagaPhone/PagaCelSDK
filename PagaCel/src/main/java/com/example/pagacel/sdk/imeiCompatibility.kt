package com.example.pagacel.sdk
import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.telephony.TelephonyManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class imeiCompatibility {
    companion object {

        private val REQUEST_READ_PHONE_STATE = 123

        /*
        @RequiresApi(Build.VERSION_CODES.O)
        fun getIMEI(activity: Activity, onIMEIReady: (String?) -> Unit) {
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.READ_PHONE_STATE), REQUEST_READ_PHONE_STATE)
            } else {
                val telephonyManager = activity.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                val imei = telephonyManager.imei
                onIMEIReady(imei)
            }
        }*/


        fun pruebasToastFunciones(context: Context) {
            Toast.makeText(context,"Se integro funcion de forma correcta.", Toast.LENGTH_LONG).show()
            //return "Se integro funcion de forma correcta."

        }
    }
}