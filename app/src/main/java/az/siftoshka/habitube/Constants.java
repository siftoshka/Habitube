package az.siftoshka.habitube;

public final class Constants {

    public static final class DB {
        public static final String WATCHED = "watched";
        public static final String PLANNED = "planned";
        public static final String MOVIE_TABLE = "movies";
        public static final String SHOW_TABLE = "shows";
    }

    public static final class FIREBASE {
        public static final String WATCHED_MOVIE = "movieWatched";
        public static final String WATCHED_SHOW = "showWatched";
        public static final String PLANNING_MOVIE = "moviePlanning";
        public static final String PLANNING_SHOW = "showPlanning";
    }

    public static final class SYSTEM {
        public static final String IMDB_WEBSITE = "https://www.imdb.com/title/";
        public static final String IMDB_PERSON = "https://www.imdb.com/name/";
        public static final String DEV_TELEGRAM = "https://t.me/siftoshka";
        public static final String DEV_GITHUB = "https://github.com/siftoshka";
        public static final String DEV_INSTAGRAM = "https://www.instagram.com/siftoshka";
        public static final String DESIGNER_FREEPIK = "https://www.freepik.com/";
        public static final String DESIGNER_OKTAY = "https://www.instagram.com/ok__die";
        public static final String FLATICON = "https://www.flaticon.com";
        public static final String API_URL = "https://api.themoviedb.org/3/";
        public static final String IMAGE_URL = "https://image.tmdb.org/t/p/original";
        public static final String YOUTUBE_URL = "https://www.youtube.com/watch?v=";
        public static final String VIMEO_URL = "https://vimeo.com/";
        public static final String MOVIE_THEMOVIEDB = "https://www.themoviedb.org/movie/";
        public static final String TV_THEMOVIEDB = "https://www.themoviedb.org/tv/";
    }

    public static final class DI {
        public static final String APP_SCOPE = "APP_SCOPE";
        public static final String POST_SCOPE = "POST_SCOPE";
    }
}
