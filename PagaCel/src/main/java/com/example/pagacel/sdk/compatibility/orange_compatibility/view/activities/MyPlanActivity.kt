package com.example.pagacel.sdk.compatibility.orange_compatibility.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pagacel.R
import kotlinx.android.synthetic.main.activity_my_plan.*

class MyPlanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_plan)

        myPlanGoToBackTextView.setOnClickListener {
            finish()
        }

        myPlanToolbar.setOnClickListener {
            finish()
        }
    }
}