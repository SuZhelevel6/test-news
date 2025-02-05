package com.suzhe.news.fragment

import android.content.Intent
import android.view.View
import androidx.annotation.IdRes

/**
 *@Author: 22122
 *@Date: 2025/2/5 下午8:15
 *@Version: v1.0.0
 *@Description: TODO
 **/
abstract class BaseCommonFragment : BaseFragment() {
    fun <T : View?> findViewById(@IdRes id: Int): T {
        return requireView().findViewById(id)
    }

}