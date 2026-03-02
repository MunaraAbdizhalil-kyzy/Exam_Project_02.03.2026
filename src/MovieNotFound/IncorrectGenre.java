package MovieNotFound;

public class IncorrectGenre extends RuntimeException {
    public IncorrectGenre(String message) {
        super(message);
    }
}
