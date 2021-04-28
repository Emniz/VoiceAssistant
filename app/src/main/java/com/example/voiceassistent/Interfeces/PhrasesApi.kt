package com.example.voiceassistent.Interfeces

import com.example.voiceassistent.Phrases.Phrase
import retrofit2.Call
import retrofit2.http.GET

interface PhrasesApi {
    @GET("/api/1.0/?method=getQuote&format=json&lang=ru")
    fun getPhrases(): Call<Phrase?>?
}