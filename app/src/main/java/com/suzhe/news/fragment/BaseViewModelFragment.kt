package com.suzhe.news.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.suzhe.news.utils.ReflectUtil

/**
 *@Author: 22122
 *@Date: 2025/2/5 下午10:57
 *@Version: v1.0.0
 *@Description: TODO
 **/
abstract class BaseViewModelFragment<VB : ViewBinding> : BaseLogicFragment() {
    var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ReflectUtil.newViewBinding(layoutInflater, this.javaClass)
    }

    override fun getLayoutView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}