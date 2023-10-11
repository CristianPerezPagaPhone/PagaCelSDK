package com.example.pagacel.sdk.compatibility.orange_compatibility.view.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import com.example.pagacel.R
import com.example.pagacel.sdk.compatibility.orange_compatibility.models.responses.ValidateCompatibilityResponse
import com.example.pagacel.sdk.compatibility.orange_compatibility.view.views.CompatibilityDialogView
import com.example.pagacel.sdk.utils.views.common.SimpleDialog
import kotlinx.android.synthetic.main.dialog_compatibility_information.*

import kotlinx.android.synthetic.main.dialog_loading.*

class ShowCompatibilityInformationDialog(context: Context) : Dialog(context),
    CompatibilityDialogView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_compatibility_information)
        setCancelable(false)
        //window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialogCompatibilityInfoAceptButton.setOnClickListener {
            dismiss()
        }
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

    override fun showInformation(validateCompatibilityResponse: ValidateCompatibilityResponse) {
        dialogCompatibilityInfoTitleTextView.text = validateCompatibilityResponse.message

        dialogCompatibilityInfoIMEITextView.text = validateCompatibilityResponse.model.imei.imei
        dialogCompatibilityInfoBlockedTextView.text = validateCompatibilityResponse.model.imei.blocked
        dialogCompatibilityInfoSubCategoryTextView.text = validateCompatibilityResponse.model.imei.sub_category
        dialogCompatibilityInfoEsimTextView.text = validateCompatibilityResponse.model.imei.soportaESIM
        dialogCompatibilityInfoVolteCapableTextView.text = validateCompatibilityResponse.model.deviceFeatures.volteCapable
        dialogCompatibilityInfoBand28TextView.text = validateCompatibilityResponse.model.deviceFeatures.band28
        dialogCompatibilityInfoModelTextView.text = validateCompatibilityResponse.model.deviceFeatures.model
        dialogCompatibilityInfoBrandTextView.text = validateCompatibilityResponse.model.deviceFeatures.brand
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