package az.siftoshka.habitube.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import az.siftoshka.habitube.utils.Constants
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Date

/**
 * Detailed Movie information.
 */
@Entity(tableName = Constants.MOVIE_TABLE)
data class Movie(
    @ColumnInfo(name = "adult") @SerializedName("adult") @Expose val adult: Boolean,
    @Ignore @ColumnInfo(name = "backdrop_path") @SerializedName("backdrop_path") @Expose val backdropPath: String,
    @Ignore @SerializedName("genres") @Expose val movieGenres: List<MovieGenre>,
    @PrimaryKey @ColumnInfo(name = "id") @SerializedName("id") @Expose val id: Int,
    @ColumnInfo(name = "imdb_id") @SerializedName("imdb_id") @Expose val imdbId: String,
    @ColumnInfo(name = "original_title") @SerializedName("original_title") @Expose val originalTitle: String,
    @ColumnInfo(name = "overview") @SerializedName("overview") @Expose val overview: String,
    @ColumnInfo(name = "popularity") @SerializedName("popularity") @Expose val popularity: Double,
    @ColumnInfo(name = "poster_path") @SerializedName("poster_path") @Expose val posterPath: String,
    @ColumnInfo(name = "release_date") @SerializedName("release_date") @Expose val releaseDate: String,
    @ColumnInfo(name = "runtime") @SerializedName("runtime") @Expose val runtime: Int,
    @ColumnInfo(name = "status") @SerializedName("status") @Expose val status: String,
    @ColumnInfo(name = "title") @SerializedName("title") @Expose val title: String,
    @ColumnInfo(name = "vote_average") @SerializedName("vote_average") @Expose val voteAverage: Double,
    @ColumnInfo(name = "vote_count") @SerializedName("vote_count") @Expose val voteCount: Int,
    @ColumnInfo(name = "budget") @SerializedName("budget") @Expose val budget: Long,
    @ColumnInfo(name = "revenue") @SerializedName("revenue") @Expose val revenue: Long,
    @ColumnInfo(name = "added_date") val addedDate: Date,
    @ColumnInfo(name = "my_rating") val myRating: Float
)

data class MovieGenre(
    val movieId: Int,
    @SerializedName("id") @Expose val id: Int,
    @SerializedName("name") @Expose val name: String
)