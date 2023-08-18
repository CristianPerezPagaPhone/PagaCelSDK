package com.pagacel.sdk.compatibility

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.pagacel.compatibility.R

class SettingsCompatibility @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyles:Int = 0,
    defStyleRes:Int = 0,
    ):LinearLayout(context,attrs, defStyles, defStyleRes) {
        init {
            LayoutInflater.from(context).inflate(R.layout.component_go_to_settings,this,true)
            var btn = findViewById<Button>(R.id.btnPrueba)

            btn.setOnClickListener {
                Toast.makeText(context, "Entrando a la configuracion", Toast.LENGTH_LONG).show()
            }
        }
}