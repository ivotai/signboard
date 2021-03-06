package com.unicorn.signboard.merchant.add

import com.unicorn.signboard.signboard.SignBoard
import java.io.Serializable

data class Merchant(
    val objectId: String = "",
    var address: String = "",
    var houseNumberPicture: UploadResponse? = null,
    val houseNumberPictureLink: String = "",
    var name: String = "",
    var operateType: Obj? = null,
    var operateStatus: Obj? = null,
    var area: Obj? = null,
    val storeCount: Int = 1,
    val region: Obj? = null,
    var coordinateX: Double = 0.0,
    var coordinateY: Double = 0.0,
    val signBoardList: List<SignBoard> = ArrayList<SignBoard>().apply { add(SignBoard()) },
    val registrationTime: Long = 0,
    var original: Int = 1, // 0表复制出来
    var originalId: String = ""
) : Serializable

class Obj(
    val objectId: String,
    val name: String
) : Serializable
