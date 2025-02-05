package com.suzhe.news.activity

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.suzhe.news.utils.ReflectUtil

/**
 *@Author: 22122
 *@Date: 2025/2/5 下午10:27
 *@Version: v1.0.0
 *@Description: TODO
 **/
/**
 * 通用ViewModel Activity
 * 包括ViewBinding，主要是处理每次要setContentView
 * 以及自动创建ViewModel
 * 以及viewModel的通用观察处理
 */
open class BaseViewModelActivity<VB : ViewBinding> : BaseLogicActivity() {
    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //调用inflate方法，创建viewBinding
        binding = ReflectUtil.newViewBinding(layoutInflater, javaClass)

        setContentView(binding.root)
    }
}