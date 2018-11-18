package com.unicorn.signboard.signboard

import android.view.View
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding2.widget.textChanges
import com.unicorn.signboard.R
import com.unicorn.signboard.app.RxBus
import com.unicorn.signboard.app.adapter.MyAdapter
import com.unicorn.signboard.app.adapter.MyHolder
import com.unicorn.signboard.app.safeClicks
import com.unicorn.signboard.merchant.SignboardCountChangeEvent
import kotlinx.android.synthetic.main.item_signboard.*

class SignboardAdapter : MyAdapter<SignBoard, MyHolder>(R.layout.item_signboard) {

    override fun bindIntent(helper: MyHolder, viewType: Int) {
        helper.apply {
            ivDelete.safeClicks().subscribe {
                remove(adapterPosition)
                RxBus.post(SignboardCountChangeEvent())
            }
            tvHeight.textChanges().filter { it.isNotBlank() }.map { it.toString().toInt() }.subscribe {
                mData[helper.adapterPosition].height = it
            }
            tvWidth.textChanges().filter { it.isNotBlank() }.map { it.toString().toInt() }.subscribe {
                mData[helper.adapterPosition].width = it
            }
        }
    }

    override fun convert(helper: MyHolder, item: SignBoard) {
        helper.apply {
            val temp = item.picture
            if (temp == null)
                Glide.with(mContext).load(R.mipmap.add_photo).into(ivPhoto)
            else
                Glide.with(mContext).load(temp.filename).into(ivPhoto)
            ivDelete.visibility = if (adapterPosition == 0) View.INVISIBLE else View.VISIBLE
            tvType.text = item.type.name
            tvSetupType.text = item.setupType.name
            tvMaterial.text = item.material.name
            tvExternalDistance.text = item.externalDistance.name
            tvHeight.setText(item.height.toString())   // 高度
            tvWidth.setText(item.width.toString())     // 宽度
        }
    }

}