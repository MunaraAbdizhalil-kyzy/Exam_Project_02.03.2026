package Dao.DaoImpl;

import Database.Database;
import MovieNotFound.MovieNotFound;
import model.Enum.Genre;
import model.Movie;

import java.util.Arrays;

public class MovieDaoImpl implements MovieDao{
            private Database database;

            public MovieDaoImpl(Database database) {
                this.database = database;
            }

            @Override
            public void createMovie(Movie movies) {
                Movie[] movies1 = Arrays.copyOf(database.getMovies(),database.getMovies().length+1);
                movies1[movies1.length-1] = movies;
                database.setMovies(movies1);
            }

            @Override
            public Movie[] getAllMovies() {
                return database.getMovies();
            }

            @Override
            public void updateMovies(long id, Movie movie) {
                for (int i = 0; i < getAllMovies().length; i++) {
                    if (database.getMovies()[i].getId()==id) {
                        database.getMovies()[i]=movie;
                        if(movie.getName() != null) {
                            database.getMovies()[i].setName(movie.getName());
                        }
                        if(movie.getDirector() != null){
                            database.getMovies()[i].setDirector(movie.getDirector());
                        }
                        if(movie.getCountry() != null){
                            database.getMovies()[i].setCountry(movie.getCountry());
                        }
                        if(movie.getReleaseDate() != null){
                            database.getMovies()[i].setReleaseDate(movie.getReleaseDate());
                        }
                        if(movie.getGenre() != null){
                            database.getMovies()[i].setGenre(movie.getGenre());
                        }
                        database.getMovies()[i]=movie;
                    }
                }
            }

            @Override
            public void deleteMovie(long id) {
                Movie[]movies = new Movie[database.getMovies().length-1];
                int counter = 0;
                boolean exists = false;
                for (int i = 0; i < getAllMovies().length; i++) {
                    exists = true;
                }

                if(exists){
                    for (int i = 0; i < getAllMovies().length; i++) {
                        if(database.getMovies()[i].getId()==id){
                            movies[counter++] = database.getMovies()[i];
                        }
                    }
                    database.setMovies(movies);
                }
            }

            @Override
            public Movie getAllMoviesById(long id) {
                for (int i = 0; i < getAllMovies().length; i++) {
                    if(database.getMovies()[i].getId()==id){
                        return database.getMovies()[i];
                    }
                }throw new MovieNotFound("Movie eith id " + id + " not found!");
            }

            @Override
            public Movie[] getMoviesByGenre(Genre genre) {
                if (genre == null) {
                    return new Movie[0];
                }
                Movie[] movies = database.getMovies();
                int count = 0;
                for (int i = 0; i < movies.length; i++) {
                    if (genre.equals(movies[i].getGenre())) {
                        count++;
                    }
                }
                Movie[] result = new Movie[count];
                int index = 0;
                for (int i = 0; i < movies.length; i++) {
                    if (genre.equals(movies[i].getGenre())) {
                        result[index++] = movies[i];
                    }
                }

                return result;
    }

}
