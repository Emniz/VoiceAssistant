package com.example.voiceassistent.Phrases

import com.example.voiceassistent.Interfeces.PhrasesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhraseService {
    fun getApi(): PhrasesApi? {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.forismatic.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(PhrasesApi::class.java)
    }
}