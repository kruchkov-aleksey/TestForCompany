package com.example.testforcompany.data.model

import com.google.gson.annotations.SerializedName

data class ResponseWrapperSearch<T>(
    @SerializedName("abilities")
    val abilities: T

)
