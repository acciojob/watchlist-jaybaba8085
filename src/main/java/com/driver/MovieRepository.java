package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

     HashMap<String, Movie> movies = new HashMap<>();
     HashMap<String, Director> directors = new HashMap<>();
     HashMap<Director,Movie>pair= new HashMap<>();
    public void addMovie(Movie movie) {
        movies.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directors.put(director.getName(), director);
    }
    public void addMovieDirectorPair(String movieName, String directorName)
    {
        Movie movie = movies.get(movieName);
        Director director = directors.get(directorName);
        pair.put(director,movie);
    }
    public Movie getMovieByName(String name) {
        return movies.get(name);
    }

    public Director getDirectorByName(String name) {
        return directors.get(name);
    }

    public List<Movie> getMoviesByDirectorName(String director) {
        List<Movie> moviesByDirector = new ArrayList<>();
        for (Movie movie : pair.values())
            {
                moviesByDirector.add(movie);
            }
        return moviesByDirector;
    }
    public List<Movie> findAllMovies() {
        return new ArrayList<>(movies.values());
    }
    public void deleteDirectorByName(String name) {
        directors.remove(name);
    }
    public void deleteAllDirectors() {
        directors.clear();
    }
}
