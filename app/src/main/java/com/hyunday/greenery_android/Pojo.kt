package com.hyunday.greenery_android

import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class Pojo(
    @SerializedName("id")
    var id: String?,

    @SerializedName("temperature")
    var temperature: String?,

    @SerializedName("humidity")
    var humidity: String?,

    @SerializedName("solid_humidity")
    var solid_humidity: String?,

    @SerializedName("created_at")
    var created_at: String?
)