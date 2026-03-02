package Database;

import model.Movie;

public class Database {
    private Movie[] movies;
    private int size;

    public Database(Movie[] movies) {
        this.movies = movies;

    }

    public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }

}
