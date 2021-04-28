package com.example.voiceassistent.Phrases

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.voiceassistent.Interfeces.PhrasesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.function.Consumer

class PhraseToString {
    fun getPhrase(callback: Consumer<String?>) {
        val api: PhrasesApi? = PhraseService().getApi()
        val call = api?.getPhrases()
        call!!.enqueue(object : Callback<Phrase?> {
            @RequiresApi(api = Build.VERSION_CODES.N)
            override fun onResponse(
                call: Call<Phrase?>,
                response: Response<Phrase?>
            ) {
                val result = response.body()
                if (result != null) {
                    callback.accept(
                        """
                            ${result.quoteText}
                            
                            ${result.quoteAuthor}
                            """.trimIndent()
                    )
                } else {
                    callback.accept("Не удалось получить фразу!")
                }
            }
            override fun onFailure(call: Call<Phrase?>, t: Throwable) {
                Log.w("PHRASE", t.message!!)
            }
        })
    }
}