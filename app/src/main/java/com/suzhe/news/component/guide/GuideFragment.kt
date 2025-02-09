package com.suzhe.news.component.guide

import android.os.Bundle
import com.suzhe.news.databinding.FragmentGuideBinding
import com.suzhe.news.fragment.BaseViewModelFragment
import com.suzhe.news.utils.Constant

/**
 *@Author: 22122
 *@Date: 2025/2/9 下午1:09
 *@Version: v1.0.0
 *@Description: TODO
 **/
class GuideFragment : BaseViewModelFragment<FragmentGuideBinding>() {
    override fun initDatum() {
        super.initDatum()
        val data = requireArguments().getInt(Constant.ID)
        binding.icon.setImageResource(data)
    }

    companion object {
        /**
         * 创建方法
         */
        fun newInstance(data: Int): GuideFragment {
            val args = Bundle()
            args.putInt(Constant.ID, data)

            val fragment = GuideFragment()
            fragment.arguments = args
            return fragment
        }
    }
}