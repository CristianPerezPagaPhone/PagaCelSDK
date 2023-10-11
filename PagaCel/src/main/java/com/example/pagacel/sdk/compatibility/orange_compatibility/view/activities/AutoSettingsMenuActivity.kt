package com.example.pagacel.sdk.compatibility.orange_compatibility.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.pagacel.R
import com.example.pagacel.sdk.compatibility.orange_compatibility.classes.CallbackManager
import com.example.pagacel.sdk.compatibility.orange_compatibility.view.views.SettingsValidationView
import kotlinx.android.synthetic.main.activity_auto_settings_menu.*

class AutoSettingsMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_settings_menu)

        // Obtén la referencia del callback de la intención


        val callback = CallbackManager.getCallback()

        autoSettingsGoToValidateIMEILinearLayout.setOnClickListener {
            var intent = Intent(this, CompatibilityImeiActivity::class.java)
            ContextCompat.startActivity(this,intent,null)
        }

        autoSettingsGoToVolteTutorialLinearLayout.setOnClickListener {
            var intent = Intent(this, TutorialsHelpActivity::class.java)
            intent.putExtra("TUTORIAL_HELP",  R.string.cta_tutorial_volte)
            ContextCompat.startActivity(this,intent,null)
        }

        autoSettingsGoToDataTutorialLinearLayout.setOnClickListener {
            var intent = Intent(this, TutorialsHelpActivity::class.java)
            intent.putExtra("TUTORIAL_HELP",  R.string.cta_tutorial_mobile_data)
            ContextCompat.startActivity(this,intent,null)
        }

        autoSettingsGoToRoamingTutorialLinearLayout.setOnClickListener {
            var intent = Intent(this, TutorialsHelpActivity::class.java)
            intent.putExtra("TUTORIAL_HELP",  R.string.cta_tutorial_roaming)
            ContextCompat.startActivity(this,intent,null)
        }

        autoSettingsGoToAPNTutorialLinearLayout.setOnClickListener {
            var intent = Intent(this, TutorialsHelpActivity::class.java)
            intent.putExtra("TUTORIAL_HELP",  R.string.cta_tutorial_apn)
            ContextCompat.startActivity(this,intent,null)
        }

        autoSettingsGoToValidateLineButton.setOnClickListener {
            callback!!.showValidationOfLine()
        }

        autoSettingsToolbar.setOnClickListener {
            finish()
            callback!!.onTutorialBack()
        }

        autoSettingsGoToBackTextView.setOnClickListener {
            finish()
            callback!!.onTutorialBack()
        }
    }
}