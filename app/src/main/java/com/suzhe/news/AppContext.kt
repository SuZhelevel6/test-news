package com.suzhe.news

import android.app.Application
import android.util.Log
import com.tencent.mmkv.MMKV

/**
 *@Author: 22122
 *@Date: 2025/2/6 下午8:52
 *@Version: v1.0.0
 *@Description: TODO
 **/
class AppContext : Application() {
    override fun onCreate() {
        super.onCreate()
        initMMKV()
    }

    private fun initMMKV() {
        var rootDir = MMKV.initialize(this)
        Log.d("MMKV", "rootDir = $rootDir")
    }
}