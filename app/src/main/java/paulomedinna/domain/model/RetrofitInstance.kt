package paulomedinna.domain.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {

    companion object {

        fun getRetrofitInstance(): Retrofit {
             val BASE_URL = "http://www.omdbapi.com"

               val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit
        }
    }
}