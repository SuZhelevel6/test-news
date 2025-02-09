package com.suzhe.news.component.guide

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 *@Author: 22122
 *@Date: 2025/2/9 下午1:04
 *@Version: v1.0.0
 *@Description: TODO
 **/
class GuideAdapter(var context: Context,var fragmentManager: FragmentManager) :FragmentPagerAdapter(fragmentManager){
    private var datum : MutableList<Int> = mutableListOf()
    override fun getCount(): Int {
        return datum.size
    }

    override fun getItem(p0: Int): Fragment {
        return GuideFragment.newInstance(datum[p0])
    }

    fun setDatum(datum: MutableList<Int>) {
        this.datum.clear()
        this.datum.addAll(datum)
        notifyDataSetChanged()

    }
}