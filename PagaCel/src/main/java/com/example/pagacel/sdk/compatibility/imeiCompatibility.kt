package com.example.pagacel.sdk.compatibility

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.pagacel.sdk.compatibility.orange_compatibility.view.dialogs.ValidateIMEIDialog
import androidx.fragment.app.FragmentManager
import com.example.pagacel.sdk.compatibility.orange_compatibility.view.activities.CompatibilityImeiActivity


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

        /*fun showCustomDialog(context: Context, title: String, message: String) {

            val imeiDialog = ValidateIMEIDialog.newInstance()
            imeiDialog.show(fragmentManager, ValidateIMEIDialog::class.simpleName)
            imeiDialog.initInteractionListener(context)

            /*val dialog = AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                .create()

            dialog.show()*/
        }*/


        fun showCustomDialog(/*fragmentManager: FragmentManager,*/ context: Context, title: String, message: String) {
            //val imeiDialog = ValidateIMEIDialog.newInstance()
            //imeiDialog.show(fragmentManager, ValidateIMEIDialog::class.simpleName)


            var intent = Intent(context, CompatibilityImeiActivity::class.java)
            ContextCompat.startActivity(context,intent,null)
        }

    }
}