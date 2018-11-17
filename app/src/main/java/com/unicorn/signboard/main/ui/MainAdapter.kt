package com.unicorn.signboard.main.ui

import android.content.Intent
import com.unicorn.signboard.R
import com.unicorn.signboard.app.adapter.MyAdapter
import com.unicorn.signboard.app.adapter.MyHolder
import com.unicorn.signboard.app.safeClicks
import com.unicorn.signboard.merchant.add.AddMerchantAct
import com.unicorn.signboard.merchant.list.ui.MerchantListAct
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
                mContext.startActivity(
                    Intent(
                        mContext,
                        if (helper.adapterPosition == 0) AddMerchantAct::class.java
                        else MerchantListAct::class.java
                    )
                )
            }
        }
    }


}