package com.suzhe.news.utils

import com.tencent.mmkv.MMKV

/**
 *@Author: 22122
 *@Date: 2025/2/6 下午8:56
 *@Version: v1.0.0
 *@Description: TODO
 **/
/**
 * 偏好设置工具类
 */
object PreferenceUtil {
    val p: MMKV by lazy {
        MMKV.defaultMMKV()!!
    }

    /**
     * 是否显示引导界面
     *
     * @return
     */
    fun isShowGuide(): Boolean {
        return getBoolean(SHOW_GUIDE, true)
    }

    /**
     * 设置是否显示引导界面
     *
     * @param value
     */
    fun setShowGuide(value: Boolean) {
        putBoolean(SHOW_GUIDE, value)
    }



    //region 辅助方法
    private fun getString(key: String): String? {
        return p.decodeString(key, null)
    }

    private fun putString(key: String, value: String) {
        p.edit().putString(key, value).apply()
    }

    private fun delete(data: String) {
        p.edit().remove(data).commit()
    }


    /**
     * 获取boolean
     *
     * @param key
     * @param defaultValue
     * @return
     */
    private fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return p.getBoolean(key, defaultValue)
    }

    /**
     * 保存boolean
     *
     * @param key
     * @param value
     */
    private fun putBoolean(key: String, value: Boolean) {
        p.edit().putBoolean(key, value).apply()
    }

    //endregion

    /**
     * 是否显示引导界面key
     */
    private const val SHOW_GUIDE = "SHOW_GUIDE"
    private const val USER_ID = "user"
    private const val TOKEN = "token"
    private const val CHAT_TOKEN = "CHAT_TOKEN"
    private const val SPLASH_AD = "SPLASH_AD"
    private const val KEY_DEVICE_ID = "KEY_DEVICE_ID"
}