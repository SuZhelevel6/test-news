package com.suzhe.news

import android.os.Bundle
import android.provider.SyncStateContract
import androidx.appcompat.app.AppCompatActivity
import com.suzhe.news.activity.BaseViewModelActivity
import com.suzhe.news.component.login.LoginHomeActivity
import com.suzhe.news.databinding.ActivityMainBinding
import com.suzhe.news.utils.Constant

class MainActivity : BaseViewModelActivity<ActivityMainBinding>() {
    override fun initDatum() {
        super.initDatum()
        val action = intent.action
        if (action == Constant.ACTION_LOGIN) {
            startActivity(LoginHomeActivity::class.java)
        }
    }
}