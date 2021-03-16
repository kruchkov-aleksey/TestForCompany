package com.example.testforcompany.data.model

import com.google.gson.annotations.SerializedName

data class ResponseWrapper<T>(
    @SerializedName("forms")
    val forms: T
)

