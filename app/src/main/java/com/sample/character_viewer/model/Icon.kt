package com.sample.character_viewer.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Icon (

    @SerializedName("Height") val height : String,
    @SerializedName("URL") val url : String,
    @SerializedName("Width") val width : String
) : Parcelable