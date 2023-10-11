package com.example.pagacel.sdk.compatibility.orange_compatibility.view.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.pagacel.R
import com.example.pagacel.sdk.compatibility.orange_compatibility.classes.TutorialSlide
import com.example.pagacel.sdk.compatibility.orange_compatibility.view.adapters.TutorialSliderAdapter


import kotlinx.android.synthetic.main.activity_tutorial_help.*

class TutorialsHelpActivity : AppCompatActivity() {

    private var adapterLenght :Int = 0
    private val volteSlideAdapter = TutorialSliderAdapter(
        listOf(
            TutorialSlide(
                "",
                "1- Ingresa al icono de Ajustes.",
                R.drawable.img_tutorial_apn_1
            ),
            TutorialSlide(
                "",
                "2- Ingresa a la Opción de \"Redes móviles\"",
                R.drawable.img_tutorial_apn_2
            ),
            TutorialSlide(
                "",
                "3- Ingresa a la Opción de \"Datos móviles\"",
                R.drawable.img_tutorial_apn_3
            ),
                TutorialSlide(
                "",
                "4- Activa la Opción de \"Llamadas VoLTE\"",
                R.drawable.img_tutorial_volte_4
            )
        )
    )

    private val dataSlideAdapter = TutorialSliderAdapter(
        listOf(

            TutorialSlide(
                "",
                "1- Ingresa al icono de Ajustes.",
                R.drawable.img_tutorial_apn_1
            ),
            TutorialSlide(
                "",
                "2.-Ingresa a la Opción de \"Redes móviles\"",
                R.drawable.img_tutorial_data_1
            ),
            TutorialSlide(
                "",
                "3- Ingresa a la Opción de \"Datos móviles\"",
                R.drawable.img_tutorial_data_2
            ),
            TutorialSlide(
                "",
                "4- Activa la Opción de \"Datos móviles\"",
                R.drawable.img_tutorial_data_3
            )
        )
    )

    private val roamingSlideAdapter = TutorialSliderAdapter(
        listOf(
            TutorialSlide(
                "",
                "1- Ingresa al icono de Ajustes.",
                R.drawable.img_tutorial_apn_1
            ),
            TutorialSlide(
                "",
                "2- Ingresa a la Opción de \"Redes móviles\"",
                R.drawable.img_tutorial_apn_2
            ),
            TutorialSlide(
                "",
                "3- Ingresa a la Opción de \"Datos móviles\"",
                R.drawable.img_tutorial_apn_3
            ),
                TutorialSlide(
                "",
                "4- Activa la Opción de \"Roaming de datos\"",
                R.drawable.img_tutorial_roaming_4
            )
        )
    )

    private val apnSlideAdapter = TutorialSliderAdapter(
        listOf(
            TutorialSlide(
                "",
                "1- Deslizar la barra de \n" +
                        "notificaciones e ingresar en \n" +
                        "“Configuración”.",
                R.drawable.img_tutorial_apn_1
            ),
            TutorialSlide(
                "",
                "2-  Dar clic sobre la sección \n" +
                        "“Conexiones inalámbricas y \n" +
                        "redes”.",
                R.drawable.img_tutorial_apn_2
            ),
            TutorialSlide(
                "",
                "3- Acceder a “Red móvil”",
                R.drawable.img_tutorial_apn_3
            ),
                TutorialSlide(
                "",
                "4- Seleccionar el botón de \n" +
                        "“APN”",
                R.drawable.img_tutorial_apn_4
            ),
                TutorialSlide(
                "",
                "5- Para agregar un APN, \n" +
                        "deberemos seleccionar el \n" +
                        "símbolo de “+”",
                R.drawable.img_tutorial_apn_5
            ),
                TutorialSlide(
                "",
                "6-  Después, daremos clic \n" +
                        "sobre el campo de \n" +
                        "“Nombre”.",
                R.drawable.img_tutorial_apn_6
            ),
                TutorialSlide(
                "",
                "7- Ingresar algún nombre \n" +
                        "para identificar el APN. Dar \n" +
                        "clic en “Aceptar”.",
                R.drawable.img_tutorial_apn_7
            ),
                TutorialSlide(
                "",
                "8- A continuación, daremos \n" +
                        "clic sobre la sección “APN”.\n",
                R.drawable.img_tutorial_apn_8
            ),
                TutorialSlide(
                "",
                "9-  Escribir el APN \n" +
                        "correspondiente. Dar clic \n" +
                        "en “Aceptar”.",
                R.drawable.img_tutorial_apn_9
            ),
                TutorialSlide(
                "",
                "10- Posteriormente \n" +
                        "daremos clic sobre los 3 \n" +
                        "puntos.",
                R.drawable.img_tutorial_apn_10
            ),
                TutorialSlide(
                "",
                "11- Elegir la opción de \n" +
                        "“Guardar”.",
                R.drawable.img_tutorial_apn_11
            ),
                TutorialSlide(
                "",
                "12- Finalmente \n" +
                        "seleccionaremos el APN que \n" +
                        "acabamos de crear.",
                R.drawable.img_tutorial_apn_12
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_help)

        val tutorialType = intent.getIntExtra("TUTORIAL_HELP", 0)

        if(tutorialType == R.string.cta_tutorial_volte){
            introSliderViewPager.adapter = volteSlideAdapter
            adapterLenght = volteSlideAdapter.itemCount

            tutorialOmit.setOnClickListener {
                openNetworkSettings()
            }
        }

        if(tutorialType == R.string.cta_tutorial_mobile_data)
        {
            introSliderViewPager.adapter = dataSlideAdapter
            adapterLenght = dataSlideAdapter.itemCount
            tutorialOmit.setOnClickListener {
                openNetworkSettings()
            }
        }

        if(tutorialType == R.string.cta_tutorial_roaming)
        {
            introSliderViewPager.adapter = roamingSlideAdapter
            adapterLenght = roamingSlideAdapter.itemCount

            tutorialOmit.setOnClickListener {
                openNetworkSettings()
            }
        }


        if(tutorialType == R.string.cta_tutorial_apn){
            introSliderViewPager.adapter = apnSlideAdapter
            adapterLenght = apnSlideAdapter.itemCount

            tutorialOmit.setOnClickListener {
                openNetworkSettings()
            }
        }

        setupIndicators()
        senCurrentIndicator(0)

        introSliderViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                senCurrentIndicator(position)
            }
        })

        btnNext.setOnClickListener{
            if(introSliderViewPager.currentItem +1 < adapterLenght){
                introSliderViewPager.currentItem+=1
            }
            else{
                //finish()
                openNetworkSettings()
            }
        }
        /*tutorialOmit.setOnClickListener {
            finish()
        }*/

        tutorialToolbar.setOnClickListener {
            finish()
        }
    }

    private fun setupIndicators(){
        val indicators = arrayOfNulls<ImageView>(adapterLenght)
        val layoutParams:LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
                indicatorsContainer.addView(indicators[i])
            }
        }
    }

    private fun senCurrentIndicator(index:Int){
        val childCount = indicatorsContainer.childCount
        for (i in 0 until childCount){
            val imageView = indicatorsContainer[i] as ImageView
            if (i == index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            }

            else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }

    fun openNetworkSettings() {
        val intent = Intent()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // A partir de Android 10 (API nivel 29), puedes abrir directamente la configuración de VoLTE
            intent.action = Settings.ACTION_NETWORK_OPERATOR_SETTINGS
        } else {
            // Para versiones anteriores, abre la configuración de redes móviles
            intent.action = Settings.ACTION_DATA_ROAMING_SETTINGS
        }

        try {
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
            // Maneja cualquier excepción que pueda ocurrir al abrir la configuración
        }
    }
}