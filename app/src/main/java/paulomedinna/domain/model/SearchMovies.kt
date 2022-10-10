package paulomedinna.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SearchMovies (
    @SerializedName("Search")
    val search: List<Movie>
        ):Serializable