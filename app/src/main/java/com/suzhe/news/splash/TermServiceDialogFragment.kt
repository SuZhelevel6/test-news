package com.suzhe.news.splash

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.FragmentManager
import com.suzhe.superui.util.ScreenUtil
import com.suzhe.news.R
import com.suzhe.news.fragment.BaseDialogFragment
import com.suzhe.superui.process.SuperProcessUtil
import com.suzhe.superui.util.SuperTextUtil

/**
 *@Author: 22122
 *@Date: 2025/2/5 下午8:05
 *@Version: v1.0.0
 *@Description: TODO
 **/
/**
 * 服务条款和隐私协议对话框
 */
class TermServiceDialogFragment : BaseDialogFragment() {
    private lateinit var onAgreementClickListener: View.OnClickListener
    private lateinit var contentView:TextView
    private lateinit var primaryView:TextView
    private lateinit var disagreeView: TextView

    override fun initViews() {
        super.initViews()
        //点击弹窗外边不能关闭
        isCancelable = false

        contentView = findViewById<TextView>(R.id.content)
        primaryView = findViewById<TextView>(R.id.primary)
        disagreeView = findViewById<TextView>(R.id.disagree)
        SuperTextUtil.setLinkColor(contentView, getColor(requireContext(), R.color.link))
    }

    override fun initDatum() {
        super.initDatum()
        val content = Html.fromHtml(getString(R.string.term_service_privacy_content))
        contentView.text = content
    }

    override fun initListeners() {
        super.initListeners()
        //同意按钮点击
        primaryView.setOnClickListener {
            dismiss()
            onAgreementClickListener.onClick(it)
        }

        //不同意按钮点击
        disagreeView.setOnClickListener {
            dismiss()
            SuperProcessUtil.killApp()
        }
    }


    override fun onResume() {
        super.onResume()
        //修改宽度，默认的对话框宽度不够好看
        //参考：https://stackoverflow.com/questions/12478520/how-to-set-dialogfragments-width-and-height
        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = ((ScreenUtil.getScreenWith(requireContext()) * 0.9).toInt())
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams
    }


    override fun getLayoutView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dialog_term_service, container, false)
    }

    companion object {
        /**
         * 显示对话框
         */
        fun show(fragmentManager: FragmentManager, onAgreementClickListener: View.OnClickListener) {
            val dialogFragment = TermServiceDialogFragment()

            dialogFragment.onAgreementClickListener = onAgreementClickListener

            dialogFragment.show(fragmentManager, "TermServiceDialogFragment")
        }
    }

}