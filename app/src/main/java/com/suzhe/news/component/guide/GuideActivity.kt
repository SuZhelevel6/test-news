package com.suzhe.news.component.guide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import com.suzhe.news.MainActivity
import com.suzhe.news.R
import com.suzhe.news.activity.BaseViewModelActivity
import com.suzhe.news.component.login.LoginHomeActivity
import com.suzhe.news.databinding.ActivityGuideBinding
import com.suzhe.news.utils.Constant
import com.suzhe.news.utils.PreferenceUtil

class GuideActivity : BaseViewModelActivity<ActivityGuideBinding>() {
    private lateinit var adapter: GuideAdapter

    override fun initDatum() {
        super.initDatum()
        adapter = GuideAdapter(this,supportFragmentManager)
        binding.list.adapter = adapter

        //让指示器根据列表控件配合工作
        binding.indicator.setViewPager(binding.list)

        //适配器注册数据源观察者
        adapter.registerDataSetObserver(binding.indicator.dataSetObserver)

        var datum :MutableList<Int> = ArrayList()

        datum.add(R.drawable.guide1)
        datum.add(R.drawable.guide2)
        datum.add(R.drawable.guide3)
        datum.add(R.drawable.guide4)
        datum.add(R.drawable.guide5)

        adapter.setDatum(datum)
    }

    override fun initListeners() {
        super.initListeners()
        binding.loginOrRegister.setOnClickListener {
            Log.d("TAG","点击了登录按钮")
            setShowGuide()
            val intent = Intent(this,LoginHomeActivity::class.java)
            intent.action = Constant.ACTION_LOGIN
            startActivity(intent)
        }
        binding.experienceNow.setOnClickListener {
            Log.d("TAG","点击了体验按钮")
            setShowGuide()
            startActivityAfterFinishThis(MainActivity::class.java)
        }
    }

    private fun setShowGuide() {
        PreferenceUtil.setShowGuide(false)

    }

}