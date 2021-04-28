package com.example.voiceassistent.Phrases

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Phrase : Serializable {
    @SerializedName("quoteText")
    @Expose
    var quoteText: String? = null

    @SerializedName("quoteAuthor")
    @Expose
    var quoteAuthor: String? = null
}