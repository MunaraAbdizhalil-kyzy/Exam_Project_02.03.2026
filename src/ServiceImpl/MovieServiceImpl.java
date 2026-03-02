package ServiceImpl;

import Dao.DaoImpl.MovieDao;
import Service.MovieService;
import model.Enum.Genre;
import model.Movie;

public class MovieServiceImpl implements MovieService {
    private MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public void createMovie(Movie movies) {
        if (movies.getName() == null || movies.getName().isBlank()) {
            throw new IllegalArgumentException("Name of the movie is required");
        }

        if (movies.getDirector() == null || movies.getDirector().isBlank()) {
            throw new IllegalArgumentException("Director of the movie is required");
        }

        if (movies.getCountry() == null || movies.getCountry().isBlank()) {
            throw new IllegalArgumentException("Country of the movie is required");
        }

        if (movies.getReleaseDate() == null) {
            throw new IllegalArgumentException("Release Date of the movie is required");
        }

        if (movies.getGenre() == null) {
            throw new IllegalArgumentException("Genre of the movie is required");
        }
        movieDao.createMovie(movies);
    }

    @Override
    public Movie[] getAllMovies() {
        return movieDao.getAllMovies();
    }

    @Override
    public void updateMovies(long id, Movie movie) {
        if(id <= 0){
            throw new IllegalArgumentException("Incorrect movies ID");
        }

        Movie existed = movieDao.getAllMoviesById(id);
        if(existed == null){
            throw new IllegalArgumentException("Movies with id " + id + " not found!");
        }
        movieDao.updateMovies(id, movie);
    }

    @Override
    public void deleteMovie(long id) {
        if(id <= 0){
            throw new IllegalArgumentException("Incorrect movies ID");
        }

        Movie existed = movieDao.getAllMoviesById(id);
        if(existed == null){
            throw new IllegalArgumentException("Movies with id " + id + " not found!");
        }
        movieDao.deleteMovie(id);
    }

    @Override
    public Movie getAllMoviesById(long id) {
        if(id <= 0){
            throw new IllegalArgumentException("Incorrect movies ID");
        }

        Movie movies = movieDao.getAllMoviesById(id);
        if(movies == null){
            throw new IllegalArgumentException("Movies with id " + id + " not found!");
        }
        return movies;
    }

    @Override
    public Movie[] getMoviesByGenre(Genre genre) {
        if (genre == null) {
            throw new IllegalArgumentException("Movies with genre " + genre + " not found!");
        }
        return movieDao.getMoviesByGenre(genre);
    }

}
