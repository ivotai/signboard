package com.unicorn.signboard.main.ui

import android.app.Activity
import android.content.Intent
import com.unicorn.signboard.R
import com.unicorn.signboard.app.Key
import com.unicorn.signboard.app.adapter.MyAdapter
import com.unicorn.signboard.app.adapter.MyHolder
import com.unicorn.signboard.app.safeClicks
import com.unicorn.signboard.input.InputAct
import com.unicorn.signboard.list.ListAct
import com.unicorn.signboard.login.ui.LoginAct
import com.unicorn.signboard.statistics.ui.StatAct
import com.unicorn.signboard.summary.SummaryAct
import kotlinx.android.synthetic.main.item_right_arrow.*

class MainAdapter : MyAdapter<String, MyHolder>(R.layout.item_right_arrow) {

    override fun convert(helper: MyHolder, item: String) {
        helper.apply {
            tvOperation.text = item
        }
    }

    override fun bindIntent(helper: MyHolder, viewType: Int) {
        helper.apply {
            root.safeClicks().subscribe {
                val item = mData[helper.adapterPosition]
                when (item) {
                    "商户录入" -> mContext.startActivity(Intent(mContext, InputAct::class.java))
                    "商户列表" -> mContext.startActivity(Intent(mContext, ListAct::class.java))
                    "登记统计" -> mContext.startActivity(Intent(mContext, StatAct::class.java))
                    "用户统计" -> mContext.startActivity(Intent(mContext, SummaryAct::class.java))
                    "退出" -> {
                        mContext.startActivity(Intent(mContext, LoginAct::class.java).apply {
                            putExtra(Key.logout, true)
                        })
                        val act = mContext as Activity
                        act.finish()
                    }
                }
            }
        }
    }

}