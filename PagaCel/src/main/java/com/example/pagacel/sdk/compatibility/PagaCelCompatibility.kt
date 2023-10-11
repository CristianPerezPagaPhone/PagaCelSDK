package com.example.pagacel.sdk.compatibility

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.pagacel.sdk.compatibility.orange_compatibility.api.AutoSettingsApi
import com.example.pagacel.sdk.compatibility.orange_compatibility.classes.CallbackManager
import com.example.pagacel.sdk.compatibility.orange_compatibility.view.activities.AutoSettingsMenuActivity
import kotlinx.coroutines.launch
import com.example.pagacel.sdk.compatibility.orange_compatibility.models.requests.GenerateTokenRequest
import com.example.pagacel.sdk.compatibility.orange_compatibility.models.requests.GetLineStatusRequest
import com.example.pagacel.sdk.utils.views.common.SimpleDialog
import com.example.pagacel.sdk.utils.views.dialogs.SimpleLoadingDialog
import kotlinx.android.synthetic.main.activity_compatibility_imei.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PagaCelCompatibility {
    companion object {

        private var loadingDialog: SimpleDialog? = null

        fun showTutorialsMenu(/*fragmentManager: FragmentManager,*/ context: Context) {
            var intent = Intent(context, AutoSettingsMenuActivity::class.java)
            //intent.putExtra("TUTORIAL_HELP",  R.string.cta_tutorial_volte)
            ContextCompat.startActivity(context,intent,null)
        }

        fun getLineStatus(context: Context, lineNumber:String){

            loadingDialog = SimpleLoadingDialog(context)

            loadingDialog?.showDialog()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://cyc-ws-api-75651beb1eef.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiServiceToken = retrofit.create(AutoSettingsApi::class.java)

            GlobalScope.launch(Dispatchers.Main) {
                try {
                    val tokenResponse = apiServiceToken
                        .generateToken(
                            GenerateTokenRequest
                                (
                                user = "MTAwMDU5MFVTMDcyMTQ4LVBQLUFQSQ==",
                                password = "MDAwMTAwN1BQMTI5MTQ4LUFQSTEwNTkxMDAwNTkwVVMwNzIxNDgtUFAtQVBJ"
                            )
                        )

                    if(tokenResponse.status == "200"){
                        val apiService = getRetrofit(tokenResponse.token).create(AutoSettingsApi::class.java)
                        GlobalScope.launch(Dispatchers.Main) {
                            try {
                                val lineInfoResponse = apiService
                                    .getLineStatus(
                                        request = GetLineStatusRequest
                                            (
                                            msisdn = lineNumber.replace("-","").replace(" ","")
                                        )
                                    )

                                if(lineInfoResponse.status == 200){
                                    val callback = CallbackManager.getCallback()
                                    if (callback != null) {
                                        callback!!.showPlanInfo(lineInfoResponse)
                                    }
                                    loadingDialog?.hideDialog()
                                }
                                else{
                                    loadingDialog?.hideDialog()
                                    Toast.makeText(context,lineInfoResponse.message,Toast.LENGTH_LONG).show()
                                }

                            } catch (e: Exception) {
                                loadingDialog?.hideDialog()
                                Toast.makeText(context, "Ocurrio un error, por favor intenta nuevamente.", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    else{
                        loadingDialog?.hideDialog()
                        Toast.makeText(context,tokenResponse.message,Toast.LENGTH_LONG).show()
                    }

                } catch (e: Exception) {
                    loadingDialog?.hideDialog()
                    Toast.makeText(context, "Ocurrio un error, por favor intenta nuevamente.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        private fun getRetrofit(token:String): Retrofit {

            // Crear un interceptor para agregar el encabezado
            val headerInterceptor = Interceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("authorization-cc", "Bearer-PC $token")
                    .build()
                chain.proceed(request)
            }

            // Configurar OkHttpClient con el interceptor
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .build()


            return Retrofit.Builder()
                .baseUrl("https://cyc-ws-api-75651beb1eef.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
    }
}