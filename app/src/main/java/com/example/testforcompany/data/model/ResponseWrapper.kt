package com.example.testforcompany.data.model

import com.google.gson.annotations.SerializedName

data class ResponseWrapper<T>(
    @SerializedName("results")
    val results: T
)

