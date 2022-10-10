package paulomedinna.data.mapper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import paulomedinna.app.apitesteoficial.R
import paulomedinna.domain.model.Movie


class MoviesAdapter(
    private val onItemClicked: (Movie) -> Unit,
    val items: List<Movie>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MoviesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_filmes, parent, false)
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MoviesViewHolder -> {
                holder.bind(items[position], onItemClicked)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class MoviesViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val movieTitle = itemView.findViewById<TextView>(R.id.title)
        val imageMovie = itemView.findViewById<ImageView>(R.id.image)

        fun bind(movie: Movie, onItemClicked: (Movie) -> Unit) {

            movieTitle.text = movie.title

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(movie)
                .into(imageMovie)

            itemView.setOnClickListener {
                onItemClicked(movie)
            }
        }

    }
}




