package com.example.pagacel.sdk.utils.views.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import com.example.pagacel.R
import com.example.pagacel.sdk.utils.views.common.SimpleDialog

import kotlinx.android.synthetic.main.dialog_loading.*

class SimpleLoadingDialog(context: Context) : Dialog(context), SimpleDialog {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_loading)
        setCancelable(false)
        //window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun showDialog() {
        if (!isShowing) {
            show()
        }
    }

    override fun hideDialog() {
        if (isShowing) {
            dismiss()
        }
    }

    override fun changeMessage(message: Int) {
        dialogMessageTextView.setText(message)
    }

    override fun changeMessage(message: String) {
        dialogMessageTextView.text = message
    }

    override fun changeTitle(title: Int) {
        setTitle(title)
    }

    override fun changeTitle(title: String) {
        setTitle(title)
    }
}