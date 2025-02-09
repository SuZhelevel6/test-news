package com.suzhe.news.component.guide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.suzhe.news.R
import com.suzhe.news.activity.BaseViewModelActivity
import com.suzhe.news.databinding.ActivityGuideBinding
import com.suzhe.news.utils.PreferenceUtil

class GuideActivity : BaseViewModelActivity<ActivityGuideBinding>() {
    private lateinit var adapter: GuideAdapter

    override fun initDatum() {
        super.initDatum()
        adapter = GuideAdapter(this,supportFragmentManager)
        binding.list.adapter = adapter

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
        }
        binding.experienceNow.setOnClickListener {
            Log.d("TAG","点击了体验按钮")
            setShowGuide()
        }
    }

    private fun setShowGuide() {
        PreferenceUtil.setShowGuide(false)

    }

}