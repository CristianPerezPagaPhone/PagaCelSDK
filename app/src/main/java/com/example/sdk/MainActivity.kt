package com.example.sdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pagacel.sdk.compatibility.PagaCelCompatibility
import com.example.pagacel.sdk.compatibility.orange_compatibility.classes.CallbackManager
import com.example.pagacel.sdk.compatibility.orange_compatibility.models.responses.GetLineStatusModel
import com.example.pagacel.sdk.compatibility.orange_compatibility.models.responses.GetLineStatusResponse
import com.example.pagacel.sdk.compatibility.orange_compatibility.view.views.SettingsValidationView
import com.example.sdk.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Ahora puedes acceder a tus vistas por su ID utilizando binding
        val miTextView = binding.botonConfiguracion
        val miTextView2 = binding.botonConfiguracion2


        val callback = object : SettingsValidationView {

            override fun showPlanInfo(lineResponse: GetLineStatusResponse) {
                Toast.makeText(this@MainActivity, "Linea: ${lineResponse.model!!.mvnoInformation} con oferta:${lineResponse.model!!.currentOffert} y beneficios: ${lineResponse.model!!.currentOffert} vence el: ${lineResponse.model!!.currentOffert}",Toast.LENGTH_LONG).show()
            }

            override fun showPlanErrorInfo(message: String) {
                Toast.makeText(this@MainActivity,message,Toast.LENGTH_LONG).show()
            }

            override fun showValidationOfLine() {
                Toast.makeText(this@MainActivity, "Mostrar vista de OTP", Toast.LENGTH_LONG).show()
            }

            override fun onTutorialBack() {
                Toast.makeText(this@MainActivity, "Se cerro el tutorial del SDK", Toast.LENGTH_LONG).show()
            }
        }

        CallbackManager.setCallback(callback)

        /*val intent = Intent(this, AutoSettingsMenuActivity::class.java)
        startActivity(intent)*/

        miTextView.setOnClickListener {
            PagaCelCompatibility.showTutorialsMenu(this)
        }

        miTextView2.setOnClickListener{
            PagaCelCompatibility.getLineStatus(this, "5586467852")
        }
    }

}