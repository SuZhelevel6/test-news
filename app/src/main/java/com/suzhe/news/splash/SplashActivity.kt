package com.suzhe.news.splash

import android.os.Bundle
import android.util.Log
import android.view.View
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import com.suzhe.news.R
import com.suzhe.news.activity.BaseLogicActivity
import com.suzhe.superui.util.SuperDarkUtil

class SplashActivity : BaseLogicActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun initViews() {
        super.initViews()
        //设置沉浸式状态栏
        QMUIStatusBarHelper.translucent(this)

        if (SuperDarkUtil.isDark(this)) {
            //状态栏文字白色
            QMUIStatusBarHelper.setStatusBarDarkMode(this)
        } else {
            //状态栏文字黑色
            QMUIStatusBarHelper.setStatusBarLightMode(this)
        }

        showTermsServiceAgreementDialog()
    }

    private fun showTermsServiceAgreementDialog() {
        TermServiceDialogFragment.show(supportFragmentManager) {
            Log.d("TAG", "primary OnClick")
        }
    }
}