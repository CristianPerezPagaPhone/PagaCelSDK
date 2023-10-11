package com.example.pagacel.sdk.compatibility.orange_compatibility.view.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.pagacel.R
import com.example.pagacel.sdk.compatibility.orange_compatibility.api.AutoSettingsApi
import com.example.pagacel.sdk.compatibility.orange_compatibility.models.requests.GenerateTokenRequest
import com.example.pagacel.sdk.compatibility.orange_compatibility.models.requests.ValidateCompatibilityRequest
import com.example.pagacel.sdk.compatibility.orange_compatibility.view.dialogs.ShowCompatibilityInformationDialog
import com.example.pagacel.sdk.compatibility.orange_compatibility.view.fragments.CompatibilityImeiFragment
import com.example.pagacel.sdk.compatibility.orange_compatibility.view.views.CompatibilityDialogView
import com.example.pagacel.sdk.utils.views.common.SimpleDialog
import com.example.pagacel.sdk.utils.views.dialogs.SimpleLoadingDialog
import kotlinx.android.synthetic.main.activity_compatibility_imei.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CompatibilityImeiActivity : AppCompatActivity() {

    private val compatibilityImeiFragment by lazy {
        CompatibilityImeiFragment.newInstance()
    }
    private var apiToken = ""
    private var loadingDialog: SimpleDialog? = null
    private var compatibilityInfoDialog: CompatibilityDialogView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compatibility_imei)

        loadingDialog = SimpleLoadingDialog(this)
        compatibilityInfoDialog = ShowCompatibilityInformationDialog(this)
        generateToken()

        stepOneHelpTextView.setOnClickListener{
            newCall()
        }
        compatibilityToolbar.setOnClickListener {
            finish()
        }

        compatibilityContinueTextView.setOnClickListener {
            validateIMEI()
        }
    }

    private fun generateToken() {
        loadingDialog?.showDialog()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://cyc-ws-api-75651beb1eef.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(AutoSettingsApi::class.java)

        GlobalScope.launch(Dispatchers.Main) {
            try {
                val tokenResponse = apiService
                    .generateToken(
                        GenerateTokenRequest
                        (
                            user = "MTAwMDU5MFVTMDcyMTQ4LVBQLUFQSQ==",
                            password = "MDAwMTAwN1BQMTI5MTQ4LUFQSTEwNTkxMDAwNTkwVVMwNzIxNDgtUFAtQVBJ"
                        )
                    )

                if(tokenResponse.status == "200"){
                    loadingDialog?.hideDialog()
                    apiToken = tokenResponse.token
                }
                else{
                    loadingDialog?.hideDialog()
                    Toast.makeText(this@CompatibilityImeiActivity,tokenResponse.message,Toast.LENGTH_LONG).show()
                }

            } catch (e: Exception) {
                loadingDialog?.hideDialog()
                Toast.makeText(applicationContext, "Ocurrio un error, por favor intenta nuevamente.", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    /**consumo de ws de retrofit**/

    private fun getRetrofit():Retrofit{

        // Crear un interceptor para agregar el encabezado
        val headerInterceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("authorization-cc", "Bearer-PC $apiToken")
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

    private fun validateIMEI() {
        if(!compatibilityImeiNumberEditText.text.isNullOrEmpty() && compatibilityImeiNumberEditText.text.toString().replace("-","").length ==15 ){
            imeiErrorMessageTextView.visibility = View.GONE
            goToValidateIMEI()
        }
        else
            imeiErrorMessageTextView.visibility = View.VISIBLE
    }

    fun goToValidateIMEI(){
        //consumir ws

        loadingDialog?.showDialog()
        val apiService = getRetrofit().create(AutoSettingsApi::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val validateIMEIResponse = apiService
                    .validateCompatibility(
                        request = ValidateCompatibilityRequest
                            (
                            imei = compatibilityImeiNumberEditText.text.toString().replace("-","")
                        )
                    )

                if(validateIMEIResponse.status == "200"){
                    loadingDialog?.hideDialog()
                    compatibilityInfoDialog?.showDialog()
                    compatibilityInfoDialog?.showInformation(validateIMEIResponse)
                    //Toast.makeText(this@CompatibilityImeiActivity, "${validateIMEIResponse}", Toast.LENGTH_LONG).show()
                }
                else{
                    loadingDialog?.hideDialog()
                    Toast.makeText(this@CompatibilityImeiActivity,validateIMEIResponse.message,Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                loadingDialog?.hideDialog()
                Toast.makeText(applicationContext, "Ocurrio un error, por favor intenta nuevamente.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showApiError(message:String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


    fun newCall() {
        val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:*#06#")
        startActivity(dialIntent)
        Toast.makeText(this,"Por favor, ingrese *#06# en el teclado del marcador para ver el IMEI.", Toast.LENGTH_LONG).show()
    }

    /*private fun switchFragment(fragment: Fragment, layout: Int = R.id.compatibilityContentLayout) {
        val transaction = supportFragmentManager.beginTransaction().apply {
            if (fragment.isAdded) {
                show(fragment)
            } else {
                add(layout, fragment)
            }

            supportFragmentManager.fragments.forEach {
                if (it != fragment && it.isAdded) {
                    hide(it)
                }
            }
        }
        transaction.commit()
    }*/
}