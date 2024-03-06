package com.example.bin.common.model.response

open class CommonResult(
    var success: Boolean = true,

    var code: Int = 0,

    var message: String = "success!"
)