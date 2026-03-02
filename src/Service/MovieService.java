package Service;

import model.Enum.Genre;
import model.Movie;

public interface MovieService {
    //1
    void createMovie(Movie movies);

    //2
    Movie[] getAllMovies();

    //3
    void updateMovies(long id, Movie movie);

    //4
    void deleteMovie(long id);

    //5
    Movie getAllMoviesById(long id);

    Movie[] getMoviesByGenre(Genre genre);
}
