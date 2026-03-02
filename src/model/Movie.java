package model;

import model.Enum.Genre;

import java.time.LocalDate;

public class Movie {
    private long id;
    private String name;
    private String director;
    private String country;
    LocalDate releaseDate;
    Genre genre;
    int counter = 0;

    public Movie(String name, String director, String country, LocalDate releaseDate, Genre genre) {
        this.id = ++counter;
        this.name = name;
        this.director = director;
        this.country = country;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", country='" + country + '\'' +
                ", releaseDate=" + releaseDate +
                ", genre=" + genre +
                ", counter=" + counter +
                '}';
    }
}

