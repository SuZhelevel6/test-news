package com.suzhe.news.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import com.suzhe.news.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //设置沉浸式状态栏
        QMUIStatusBarHelper.translucent(this)

        //状态栏文字黑色
        QMUIStatusBarHelper.setStatusBarLightMode(this)
    }
}