/*
 * TutorialPagerAdapter.kt - app
 * Created by JMORA on 8/20/20 2:14 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 8/20/20 2:14 PM
 */

package com.example.pagacel.sdk.compatibility.orange_compatibility.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pagacel.R
import com.example.pagacel.sdk.compatibility.orange_compatibility.view.fragments.VoltePageFragment


class VoltePagerAdapter(
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val cashInStepOneFragment by lazy {
        VoltePageFragment.newInstance(
            R.string.act_cash_in_step_one_title,
            R.drawable.img_cash_in_step_one
        )
    }

    private val cashInStepTwoFragment by lazy {
        VoltePageFragment.newInstance(
            R.string.act_cash_in_step_two_title,
            R.drawable.img_cash_in_step_two_2
        )
    }

    private val cashInStepThreeFragment by lazy {
        VoltePageFragment.newInstance(
            R.string.act_cash_in_step_three_title,
            R.drawable.img_cash_in_step_three
        )
    }

    private val cashInStepFourFragment by lazy {
        VoltePageFragment.newInstance(
            R.string.act_cash_in_step_four_title,
            R.drawable.img_cash_in_step_four
        )
    }

    private val cashInStepFiveFragment by lazy {
        VoltePageFragment.newInstance(
            R.string.act_cash_in_step_five_title,
            R.drawable.img_cash_in_step_five
        )
    }

    private val fragments = arrayListOf(
        cashInStepOneFragment,
        cashInStepTwoFragment,
        cashInStepThreeFragment,
        cashInStepFourFragment,
        cashInStepFiveFragment
    )

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}