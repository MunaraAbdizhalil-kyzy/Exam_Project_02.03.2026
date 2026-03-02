import Dao.DaoImpl.MovieDao;
import Dao.DaoImpl.MovieDaoImpl;
import Database.Database;
import MovieNotFound.IncorrectDateFormat;
import MovieNotFound.IncorrectGenre;
import Service.MovieService;
import ServiceImpl.MovieServiceImpl;
import model.Enum.Genre;
import model.Movie;

import javax.xml.transform.Source;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Database database = new Database(new Movie[]{});
    MovieDao movieDao = new MovieDaoImpl(database);
    MovieService movieService = new MovieServiceImpl(movieDao);
    Scanner scanner = new Scanner(System.in);
    while (true){
        menu();
        System.out.println("Choose the option: ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter the name of Movie: ");
                String name = scanner.next();
                System.out.println("Enter the director of Movie: ");
                String director = scanner.next();
                System.out.println("Enter the country of Movie: ");
                String country = scanner.next();


                LocalDate releaseDate = null;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                while (releaseDate == null) {
                    try {
                        System.out.println("Enter the Release Date of Movie (YYYY,MM,DD): ");
                        String dateInput = scanner.next();
                        releaseDate = LocalDate.parse(dateInput, formatter);
                    } catch (Exception e) {
                        System.out.println("Incorrect date format!");
                    }
                }
                Genre genre1 = null;
                while (genre1 == null) {
                    System.out.print("Enter the genre of the movie (UPPERCASE): ");
                    String genreInput = scanner.next();
                    try {
                        genre1 = Genre.valueOf(genreInput.toUpperCase());
                    } catch (Exception e) {
                        throw new IncorrectGenre("Incorrect genre! Please write the genre in UPPERCASE letters(ACTION,COMEDY,DRAMA,FANTASY)");
                    }
                }
                Movie movie = new Movie(name,director,country,releaseDate,genre1);
                movieService.createMovie(movie);
                break;
            case 2:
                Movie[] allMovies = movieService.getAllMovies();
                if(allMovies.length == 0){
                    System.out.println("no movies found!");
                }else{
                    for(Movie m : allMovies){
                        System.out.println(m);
                    }
                }
                break;
            case 3:
                System.out.println("Enter the genre to find Movies");
                String findGenre = scanner.next();
                Genre findGenre2 = Genre.valueOf(findGenre);
                Movie[] moviesByGenre = movieService.getMoviesByGenre(findGenre2);
                    if(moviesByGenre.length == 0){
                        System.out.println("Movies with genre " + findGenre2 + " not found!");
                    }else{
                        for (Movie m : moviesByGenre){
                            System.out.println(m);
                        }
                    }
                break;
            case 4:
                System.out.println("Enter the Movie's ID:");
                long id = scanner.nextLong();
                Movie m = movieService.getAllMoviesById(id);
                System.out.println(m);
                break;
            case 5:
                System.out.println("Enter the Movie's ID to delete: ");
                long deleteId = scanner.nextLong();
                movieService.deleteMovie(deleteId);
                System.out.println("Movie deleted successfully!");
                break;
            case 6:
                System.out.println("Enter the Movie's ID to update: ");
                long updateId = scanner.nextLong();

                System.out.println("Enter the new name of Movie: ");
                String newName = scanner.next();

                System.out.println("Enter the new director of Movie: ");
                String newDirector = scanner.next();

                System.out.println("Enter the new country of Movie: ");
                String newCountry = scanner.next();

                LocalDate newReleaseDate = null;
                DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                while (newReleaseDate == null) {
                    try {
                        System.out.println("Enter the Release Date of Movie (YYYY,MM,DD): ");
                        String dateInput = scanner.next();
                        newReleaseDate = LocalDate.parse(dateInput, newFormatter);
                    } catch (Exception e) {
                        System.out.println("Incorrect date format!");
                    }

                Genre newGenre = null;
                while (newGenre == null) {
                    System.out.println("Enter the genre of the movie must be UPPERCASE: ");
                    String genreInput = scanner.next();

                    try {
                        newGenre = Genre.valueOf(genreInput);
                    } catch (Exception e) {
                        throw new IncorrectGenre("Incorrect genre! Please write the genre in UPPERCASE letters(ACTION,COMEDY,DRAMA,FANTASY)");

                    }
                }
                Movie updateMovie = new Movie(newName,newDirector,newCountry,newReleaseDate,newGenre);
                movieService.updateMovies(updateId, updateMovie);
                System.out.println("Movie updated successfully!");
                break;
        }
    }
}
}
static void menu(){
    System.out.println("""
            1. Create the Movies
            2. Get all Movies
            3. Get Movies by Genre
            4. Get Movies by ID
            5. Delete the Movies
            6. Update the Movies""");
}
