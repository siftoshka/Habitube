package az.siftoshka.habitube.service.rest

/**
 * ApiDescription
 */
import az.siftoshka.habitube.data.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiDescription {

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int,
        @Query("language") language: String?
    ): MovieResponse

    @GET("trending/movie/day")
    suspend fun getTrendingMovies(
        @Query("page") page: Int,
        @Query("language") language: String?
    ): MovieResponse

    @GET("trending/tv/day")
    suspend fun getTrendingTVShows(
        @Query("page") page: Int,
        @Query("language") language: String?
    ): MovieResponse

    @GET("tv/airing_today")
    suspend fun getAirTodayShows(
        @Query("page") page: Int,
        @Query("language") language: String?
    ): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String?
    ): ApiMovie

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path("movie_id") movieId: Int,
        @Query("page") page: Int,
        @Query("language") language: String?
    ): MovieResponse

    @GET("movie/{movie_id}/videos")
    suspend fun getMovieVideos(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String?
    ): MovieResponse

    @GET("tv/{tv_id}")
    suspend fun getTVShow(
        @Path("tv_id") showId: Int,
        @Query("language") language: String?
    ): ApiShow

    @GET("tv/{tv_id}/similar")
    suspend fun getSimilarTVShow(
        @Path("tv_id") showId: Int,
        @Query("page") page: Int,
        @Query("language") language: String?
    ): MovieResponse

    @GET("tv/{tv_id}/videos")
    suspend fun getTVShowVideos(
        @Path("tv_id") movieId: Int,
        @Query("language") language: String?
    ): ApiVideoResponse

    @GET("person/{person_id}")
    suspend fun getMovieStar(
        @Path("person_id") starId: Int,
        @Query("language") language: String?
    ): ApiPerson

    @GET("movie/{movie_id}/credits")
    suspend fun getCredits(
        @Path("movie_id") movieId: Int
    ): ApiCredits

    @GET("tv/{tv_id}/credits")
    suspend fun getShowCredits(
        @Path("tv_id") tvId: Int
    ): ApiCredits

    @GET("person/{person_id}/movie_credits")
    suspend fun getPersonMovieCredits(
        @Path("person_id") personId: Int,
        @Query("language") language: String?
    ): ApiPersonCredits

    @GET("person/{person_id}/tv_credits")
    suspend fun getPersonShowCredits(
        @Path("person_id") personId: Int,
        @Query("language") language: String?
    ): ApiPersonCredits

    @GET("search/multi")
    suspend fun getSearchResults(
        @Query("language") language: String?,
        @Query("query") searchQuery: String?,
        @Query("page") page: Int,
        @Query("include_adult") isAdult: Boolean
    ): MovieResponse

    @GET("search/movie")
    suspend fun getMovieSearchResults(
        @Query("language") language: String?,
        @Query("query") searchQuery: String?,
        @Query("page") page: Int,
        @Query("include_adult") isAdult: Boolean
    ): MovieResponse

    @GET("search/tv")
    suspend fun getShowSearchResults(
        @Query("language") language: String?,
        @Query("query") searchQuery: String?,
        @Query("page") page: Int,
        @Query("include_adult") isAdult: Boolean
    ): MovieResponse

    @GET("search/person")
    suspend fun getPersonSearchResults(
        @Query("language") language: String?,
        @Query("query") searchQuery: String?,
        @Query("page") page: Int,
        @Query("include_adult") isAdult: Boolean
    ): MovieResponse

    @GET("discover/movie")
    suspend fun getDiscoverMovies(
        @Query("language") language: String?,
        @Query("sort_by") sort: String?,
        @Query("page") page: Int,
        @Query("include_adult") isAdult: Boolean,
        @Query("primary_release_date.gte") releaseDateUp: String?,
        @Query("primary_release_date.lte") releaseDateDown: String?,
        @Query("vote_average.gte") ratingUp: Int,
        @Query("vote_average.lte") ratingDown: Int,
        @Query("vote_count.gte") voteCount: Int,
        @Query("with_genres") genre: String?
    ): MovieResponse

    @GET("discover/tv")
    suspend fun getDiscoverShows(
        @Query("language") language: String?,
        @Query("sort_by") sort: String?,
        @Query("page") page: Int,
        @Query("include_adult") isAdult: Boolean,
        @Query("with_networks") network: String?,
        @Query("first_air_date.gte") releaseDateUp: String?,
        @Query("first_air_date.lte") releaseDateDown: String?,
        @Query("vote_average.gte") ratingUp: Int,
        @Query("vote_average.lte") ratingDown: Int,
        @Query("vote_count.gte") voteCount: Int,
        @Query("with_genres") genre: String?
    ): MovieResponse
}