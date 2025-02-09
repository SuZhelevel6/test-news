package com.suzhe.news.component.guide

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.suzhe.news.adapter.BaseFragmentPagerAdapter

/**
 *@Author: 22122
 *@Date: 2025/2/9 下午1:04
 *@Version: v1.0.0
 *@Description: TODO
 **/
class GuideAdapter(context: Context, fragmentManager: FragmentManager) :
    BaseFragmentPagerAdapter<Int>(context, fragmentManager) {

    /**
     * 获取当前位置的数据
     *
     * @param position
     * @return
     */
    override fun getItem(position: Int): Fragment {
        return GuideFragment.newInstance(getData(position))
    }

}