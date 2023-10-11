package com.example.pagacel.sdk.compatibility.orange_compatibility.view.dialogs

import android.Manifest
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import com.example.pagacel.R
import com.example.pagacel.sdk.compatibility.orange_compatibility.models.responses.ValidateCompatibilityResponse

import com.example.pagacel.sdk.compatibility.orange_compatibility.view.views.ValidateIMEIView
import com.google.android.material.internal.ViewUtils.dpToPx

import kotlinx.android.synthetic.main.dialog_get_imei.*

class ValidateIMEIDialog : DialogFragment(), ValidateIMEIView {

    companion object {
        const val TAG = "ValidateIMEIDialog"

        fun newInstance(): ValidateIMEIDialog {
            val fragment = ValidateIMEIDialog()
            val arguments = Bundle()

            fragment.arguments = arguments

            return fragment
        }

    }


    private var isCompatible = false
    private var mensaje = ""
    private var warningDialog: AlertDialog? = null
    private var imei = ""


    //private val mainViewOrangeModel: MainViewOrangeModel by sharedViewModel()

    @SuppressLint("RestrictedApi")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val layout = ConstraintLayout(requireContext())
        layout.layoutParams = (ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ))

        val backgroundColor = ColorDrawable(Color.TRANSPARENT)
        val inset = InsetDrawable(backgroundColor, dpToPx(requireContext(), 24).toInt())

        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(layout)
        dialog.window?.setGravity(Gravity.CENTER)
        dialog.window?.setBackgroundDrawable(inset)
        dialog.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )


        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_get_imei, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //registerViewModel.initViewModel(this)

        dialogValidateIMEICancelButton.setOnClickListener {
            /*registerViewModel.addReferenceCode(
                referenceCode = referenceCode
            )*/
            dismiss()
        }



        dialogValidateIMEIContinueButton.setOnClickListener {

            imei = dialogValidateIMEIInputTextInputLayout.text.toString().replace("-", "", false)


            if (imei.length.equals(15)) {

                Toast.makeText(it.context,"tamaño de letras correcto",Toast.LENGTH_LONG).show()

            } else {
                showImeiWarning(it.context)
            }


            dialogValidateIMEIErrorTextView.visibility = View.GONE
            //referenceCode = dialogValidateIMEIInputTextInputLayout.text.toString()
            //validateReferenceCode(referenceCode)

        }

        /*dialogValidateIMEIInputTextInputLayout.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {

                var a: String = dialogValidateIMEIInputTextInputLayout.text.toString()
                if (!a.equals(a.toUpperCase())) {
                    a = a.toUpperCase();
                    dialogValidateIMEIInputTextInputLayout.setText(a);
                    dialogValidateIMEIInputTextInputLayout.setSelection(
                        dialogValidateIMEIInputTextInputLayout.length()
                    ); //fix reverse texting
                }
            }
        })*/


        dialogValidateShowIMEITextView.setOnClickListener {

            //iniciarLlamada()
            showImei(it.context)

        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun hasCallPhonePermission(context: Context): Boolean {
        val permission = Manifest.permission.CALL_PHONE
        val result = context.checkSelfPermission(permission)
        return result == PackageManager.PERMISSION_GRANTED
    }

    fun showImei(context: Context) {
        // Abre la aplicación del marcador de llamadas
        val dialIntent = Intent(Intent.ACTION_DIAL)
        startActivity(dialIntent)

        // Muestra un mensaje al usuario
        // Esto puede hacerse de diversas formas, por ejemplo, con un diálogo o una vista de texto en tu actividad.
        // Aquí se muestra un mensaje en el logcat como ejemplo.
        Toast.makeText(context,"Por favor, ingrese *#06# en el teclado del marcador para ver el IMEI.",Toast.LENGTH_LONG).show()
    }




    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onValidInputs() {

    }

    override fun onInvalidInput() {

    }

    override fun onValidIMEI(): ValidateCompatibilityResponse {
        TODO("Not yet implemented")
    }


    override fun onInvalidIMEI() {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }


    /*
    private fun validateReferenceCode(request: String) {

        CoroutineScope(Dispatchers.IO).launch {
            var call = getRetrofit().create(ReferenceCodeUtilsApi::class.java)
                .validateReferenceCode("company/$request")
            val response = call.body()

            runOnUiTh read {
                if (response != null && request != "") {
                    //ChangeReferenceCode(response.refrenceCode)
                    //softPinDialog.show(supportFragmentManager, SoftPinDialog.TAG)

                    referenceCodeErrorTextView.visibility = View.GONE

                    registerViewModel.addReferenceCode(
                        referenceCode = referenceCode
                    )
                    showPosCamping()
                    dismiss()
                } else {
                    referenceCodeErrorTextView.visibility = View.VISIBLE
                }
                hideLoading()

            }
        }
    }



    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                client(
                    TokenInterceptorReferenceCode(preferenceManager = get())
                )
            )
            .build()
    }

    fun client(
        tokenInterceptor: Interceptor
    ): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(tokenInterceptor)
        return builder.build()
    }


    */

    fun showImeiWarning(context: Context){
        warningDialog = AlertDialog.Builder(context)
            .setTitle(R.string.app_name_orange)
            .setMessage(R.string.warning_imei)
            .setPositiveButton(R.string.accept) { dialog, _ ->
                dialog.dismiss()
            }
            .create()
        warningDialog?.show()
    }

}