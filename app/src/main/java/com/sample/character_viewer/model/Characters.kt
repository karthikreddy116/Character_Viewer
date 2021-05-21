package com.sample.character_viewer.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Characters (
     @SerializedName("AbstractSource") val abstractSource : String,
     @SerializedName("AbstractText") val abstractText : String,
     @SerializedName("AbstractURL") val abstractURL : String,
     @SerializedName("Heading") val heading : String,
     @SerializedName("RelatedTopics") val relatedTopics : List<RelatedTopics>
 ) : Parcelable