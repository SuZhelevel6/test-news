package com.suzhe.news.component.guide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.suzhe.news.R
import com.suzhe.news.activity.BaseViewModelActivity
import com.suzhe.news.databinding.ActivityGuideBinding

class GuideActivity : BaseViewModelActivity<ActivityGuideBinding>() {

    override fun initListeners() {
        super.initListeners()
        binding.loginOrRegister.setOnClickListener {
            Log.d("TAG","点击了登录按钮")
        }
        binding.experienceNow.setOnClickListener {
            Log.d("TAG","点击了体验按钮")
        }
    }

}