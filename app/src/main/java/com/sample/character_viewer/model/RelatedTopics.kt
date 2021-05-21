package com.sample.character_viewer.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RelatedTopics (
    @SerializedName("FirstURL") val firstURL : String,
    @SerializedName("Icon") val icon : Icon,
    @SerializedName("Result") val result : String,
    @SerializedName("Text") val text : String
) : Parcelable {

}
