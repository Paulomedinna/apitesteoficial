package paulomedinna.domain.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDataService {

    @GET("/?apikey=dfaed607")
    fun getAllPhotos(@Query("s") title: String): Call<SearchMovies>


}
