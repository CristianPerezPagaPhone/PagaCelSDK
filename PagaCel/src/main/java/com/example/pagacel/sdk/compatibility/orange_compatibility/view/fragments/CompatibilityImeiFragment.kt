package com.example.pagacel.sdk.compatibility.orange_compatibility.view.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.pagacel.R
import kotlinx.android.synthetic.main.fragment_compatibility_imei.*

class CompatibilityImeiFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_compatibility_imei, container, false)
    }

    companion object {
        fun newInstance() =
            CompatibilityImeiFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    fun call() {
        val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:*#06#")
        startActivity(dialIntent)
        Toast.makeText(requireContext(),"Por favor, ingrese *#06# en el teclado del marcador para ver el IMEI.", Toast.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        stepOneHelpTextView.setOnClickListener{
            call()
        }
    }
}