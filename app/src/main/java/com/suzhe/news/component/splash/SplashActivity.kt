package com.suzhe.news.component.splash

import android.os.Build
import android.util.Log
import android.Manifest
import com.permissionx.guolindev.PermissionX
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import com.suzhe.news.activity.BaseViewModelActivity
import com.suzhe.news.databinding.ActivitySplashBinding
import com.suzhe.superui.util.DefaultPreferenceUtil
import com.suzhe.superui.util.SuperDarkUtil

class SplashActivity : BaseViewModelActivity<ActivitySplashBinding>() {

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
    }

    override fun initDatum() {
        super.initDatum()
        if (DefaultPreferenceUtil.getInstance(this).isAcceptTermsServiceAgreement) {
            //已经同意了用户协议
            requestPermission()
        } else {
            showTermsServiceAgreementDialog()
        }
    }

    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            PermissionX.init(this).permissions(
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.READ_MEDIA_AUDIO,
                Manifest.permission.READ_MEDIA_IMAGES,
                Manifest.permission.READ_MEDIA_VIDEO,
            )
        } else {
            PermissionX.init(this).permissions(
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
            )
        }.request { allGranted, grantedList, deniedList ->
            if (allGranted) {
                Log.d("SplashActivity", "All permissions are granted!")
            } else {
                //可以在这里弹出提示告诉用户为什么需要权限
                finish()
            }
        }
    }
    private fun showTermsServiceAgreementDialog() {
        TermServiceDialogFragment.show(supportFragmentManager) {
            Log.d("TAG", "primary OnClick")
            requestPermission()
        }
    }
}