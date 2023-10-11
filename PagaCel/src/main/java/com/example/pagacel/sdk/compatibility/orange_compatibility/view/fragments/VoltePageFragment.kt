package com.example.pagacel.sdk.compatibility.orange_compatibility.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.pagacel.R
import kotlinx.android.synthetic.main.fragment_volte_help_page.*


class VoltePageFragment : Fragment() {

    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_IMAGE = "EXTRA_IMAGE"

        fun newInstance(
            @StringRes title: Int,
            @DrawableRes imageResource: Int
        ): VoltePageFragment {
            val args = Bundle()
            args.putInt(EXTRA_TITLE, title)
            args.putInt(EXTRA_IMAGE, imageResource)

            val fragment = VoltePageFragment()
            fragment.arguments = args

            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cashInPageTitleTextView.setText(requireArguments().getInt(EXTRA_TITLE))
        cashInPageImageView.setImageResource(requireArguments().getInt(EXTRA_IMAGE))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_volte_help_page, container, false)
    }

}