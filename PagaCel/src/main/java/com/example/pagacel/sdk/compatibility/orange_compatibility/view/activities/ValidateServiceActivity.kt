package com.example.pagacel.sdk.compatibility.orange_compatibility.view.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.pagacel.R
import com.example.pagacel.sdk.compatibility.orange_compatibility.classes.CallbackManager
import kotlinx.android.synthetic.main.activity_service_status.*

class ValidateServiceActivity :
    AppCompatActivity()

{

    companion object{
        private const val  TEST_VERIFY_CODE = "123456"
    }
    private var isOTPFull = false

    private var intentos = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_status)

    }

    override fun onResume() {
        super.onResume()
        hideErrors()

        autoSettingsGoToBackTextView.setOnClickListener {
            finish()
        }

        autoSettingsToolbar.setOnClickListener {
            finish()
        }

        autoSettingsGoToRequestOTPButton.setOnClickListener {
            if(validatePhoneErrors(phoneNumberEditText.text.toString().replace("-",""))){
                isOTPFull = false
                Toast.makeText(this,"OTP Solicitado", Toast.LENGTH_LONG).show()
                hideErrors()

                if(intentos ==0){
                    setListener()
                    initFocus()
                    reset()
                    intentos +=1
                }
                else{
                    reset()
                }
            }
        }

        requestOTPTextView.setOnClickListener {
            if(validatePhoneErrors(phoneNumberEditText.text.toString().replace("-",""))){
                Toast.makeText(this,"OTP Reenviado", Toast.LENGTH_LONG).show()

            }
        }
        validateStatusLineButton.setOnClickListener {
            if(validatePhoneErrors(phoneNumberEditText.text.toString().replace("-",""))){

                if(isOTPFull){

                    var dataSearched:Boolean = false
                    val callback = CallbackManager.getCallback()

                    // Luego, puedes llamar a los métodos de la interfaz cuando sea necesario
                    if (callback != null) {
                        dataSearched = true
                        if(dataSearched){
                            /*var lineResponseModel: GetLineStatusResponse = GetLineStatusResponse("el de orange", "My Orange", "Bifrost", "Activa","27/09/2023", "28/09/2023", "100 sms, 100 min, 1000 mb")
                            callback.showPlanInfo(lineResponseModel)*/
                        }
                        else
                            callback.showPlanErrorInfo("Datos enviados desde el sdk")
                    }

                    finish()
                }
                else{
                    Toast.makeText(this,"Ingresa in OTP valido", Toast.LENGTH_LONG).show()
                }
            }
        }

        // Agrega un TextWatcher al EditText
        phoneNumberEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Este método se llama antes de que cambie el texto.
                // Puedes realizar acciones previas al cambio aquí si es necesario.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Este método se llama cuando el texto está cambiando.
                // Puedes realizar acciones durante el cambio aquí si es necesario.
            }

            override fun afterTextChanged(s: Editable?) {
                // Este método se llama después de que el texto ha cambiado.
                // Puedes realizar acciones después del cambio aquí si es necesario.

                val textoIngresado = s.toString()
                // Hacer algo con el texto ingresado, por ejemplo, validaciones, actualizaciones, etc.

                phoneErrorMessageTextView.visibility = View.GONE


            }
        })

        /*otpInputsLinearLayout.setOnClickListener{
            setListener()
            initFocus()
            reset()
        }

        editTextOne.setOnClickListener {
            setListener()
            initFocus()
            reset()
        }*/

    }

    private fun validatePhoneErrors(phone:String):Boolean
    {
        var isValid = false
        if(phone ==""){
            phoneErrorMessageTextView.text="Debes de ingresar un número de telefono"
            phoneErrorMessageTextView.visibility=View.VISIBLE
        }
        else if(phone.length !=10){
            phoneErrorMessageTextView.text = "El número de telefono debe de ser de 10 digitos"
            phoneErrorMessageTextView.visibility=View.VISIBLE
        }
        else
            isValid = true

        return isValid
    }

    private  fun hideErrors(){
        phoneErrorMessageTextView.visibility = View.GONE
    }

    private fun setListener() {
        otpInputsLinearLayout.setOnClickListener{
            val inputManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(otpInputsLinearLayout.windowToken,0)
        }

        setTextChangeListener(fromEditText = editTextOne, targetEditText = editTextTwo)
        setTextChangeListener(fromEditText = editTextTwo, targetEditText = editTextThree)
        setTextChangeListener(fromEditText = editTextThree, targetEditText = editTextFour)
        setTextChangeListener(fromEditText = editTextFour, targetEditText = editTextFive)
        setTextChangeListener(fromEditText = editTextFive, targetEditText = editTextSix)
        setTextChangeListener(fromEditText = editTextSix, done ={
            verifyOTPCode()
        })
        setKeyListener(fromEditText = editTextTwo, backToEditText = editTextOne)
        setKeyListener(fromEditText = editTextThree, backToEditText = editTextTwo)
        setKeyListener(fromEditText = editTextFour, backToEditText = editTextThree)
        setKeyListener(fromEditText = editTextFive, backToEditText = editTextFour)
        setKeyListener(fromEditText = editTextSix, backToEditText = editTextFive)
    }

    private fun initFocus(){
        editTextOne.isEnabled = true

        editTextOne.postDelayed({
            editTextOne.requestFocus()
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.showSoftInput(editTextOne, InputMethodManager.SHOW_FORCED)
        }, 500)
    }

    private fun reset(){
        editTextOne.isEnabled
        editTextTwo.isEnabled
        editTextThree.isEnabled
        editTextFour.isEnabled
        editTextFive.isEnabled
        editTextSix.isEnabled

        editTextOne.setText("")
        editTextTwo.setText("")
        editTextThree.setText("")
        editTextFour.setText("")
        editTextFive.setText("")
        editTextSix.setText("")

        initFocus()
    }

    private fun setTextChangeListener(
        fromEditText:EditText,
        targetEditText: EditText? = null,
        done: (()-> Unit)? = null
    ){
        fromEditText.addTextChangedListener {
            it?.let { string ->
                if(string.isNotEmpty()){
                    targetEditText?.let{editText ->
                    editText.isEnabled =  true
                    editText.requestFocus()

                    } ?: run{
                        done?.let { done ->
                            done()
                        }
                    }

                    fromEditText.clearFocus()
                    fromEditText.isEnabled = false
                }
            }
        }
    }

    private fun setKeyListener(fromEditText:EditText,backToEditText:EditText){
        fromEditText.setOnKeyListener{_,_,event->
            if(null!=event && KeyEvent.KEYCODE_DEL ==event.keyCode){
                backToEditText.isEnabled = true
                backToEditText.requestFocus()
                backToEditText.setText("")
                fromEditText.clearFocus()
                fromEditText.isEnabled = false

            }
            false

        }
    }

    private fun verifyOTPCode(){
        val otpCode = "${editTextOne.text.toString().trim()}"+
                "${editTextTwo.text.toString().trim()}"+
                "${editTextThree.text.toString().trim()}"+
                "${editTextFour.text.toString().trim()}"+
                "${editTextFive.text.toString().trim()}"+
                "${editTextSix.text.toString().trim()}"

        if(6!= otpCode.length){
            //isOTPFull = true
            return
        }
        if(otpCode == TEST_VERIFY_CODE){
            isOTPFull=true
            Toast.makeText(this, "OTP Correcto, puedes continuar",Toast.LENGTH_LONG).show()

            val inputManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(otpInputsLinearLayout.windowToken,0)

            return
        }
        isOTPFull = false
        Toast.makeText(this, "OTP Incorrecto ",Toast.LENGTH_LONG).show()
        //reset()
    }

}
