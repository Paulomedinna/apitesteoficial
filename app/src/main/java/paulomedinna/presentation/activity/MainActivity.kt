package paulomedinna.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import paulomedinna.app.apitesteoficial.databinding.ActivityMainBinding
import paulomedinna.data.mapper.MoviesAdapter
import paulomedinna.domain.model.GetDataService
import paulomedinna.domain.model.Movie
import paulomedinna.domain.model.RetrofitInstance
import paulomedinna.domain.model.SearchMovies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), (Movie) -> Unit {
    private lateinit var binding: ActivityMainBinding
    private lateinit var moviesAdapter: MoviesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val service: GetDataService = RetrofitInstance.getRetrofitInstance().create(
            GetDataService::class.java
        )
        val call: Call<SearchMovies> = service.getAllPhotos(title = "Batman")
        call.enqueue(object : Callback<SearchMovies> {
            override fun onResponse(call: Call<SearchMovies>, response: Response<SearchMovies>) {
                Log.e("response", response.toString())
                response.body()?.run {
                    initRecyclerView(this)

                }
            }

            override fun onFailure(call: Call<SearchMovies>, t: Throwable) {
                Log.e("Throwable", t.message.toString())
            }
        })
    }

    private fun initRecyclerView(body: SearchMovies) {
        this.moviesAdapter = MoviesAdapter(this,body.search)

        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = moviesAdapter


        }
    }

    override fun invoke(p1: Movie) {
        TODO("Not yet implemented")
    }


}


