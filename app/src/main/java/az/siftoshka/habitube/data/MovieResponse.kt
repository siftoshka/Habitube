package az.siftoshka.habitube.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * MovieResponse and MovieLite files to get general information.
 */
data class MovieResponse(
    @SerializedName("page") @Expose val page: Int,
    @SerializedName("results") @Expose val results: List<MovieLite>,
    @SerializedName("total_pages") @Expose val totalPages: Int,
    @SerializedName("total_results") @Expose val totalResults: Int
)

data class MovieLite(
    @SerializedName("id") @Expose val movieId: Int,
    @SerializedName("title") @Expose val movieTitle: String,
    @SerializedName("name") @Expose val showTitle: Int,
    @SerializedName("poster_path") @Expose val movieImage: String,
    @SerializedName("backdrop_path") @Expose val backdropPath: String,
    @SerializedName("profile_path") @Expose val starImage: String,
    @SerializedName("release_date") @Expose val releaseDate: String,
    @SerializedName("vote_average") @Expose val voteAverage: Double,
    @SerializedName("first_air_date") @Expose val firstAirDate: String,
    @SerializedName("media_type") @Expose val mediaType: String
)