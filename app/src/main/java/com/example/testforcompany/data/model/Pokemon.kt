package com.example.testforcompany.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = ""
):Parcelable
