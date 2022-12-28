package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    static MovieRepository movieRepository;

    public static void addMovie(Movie movie) {
       movieRepository.addMovie(movie);
    }

    public static void addDirector(Director director) {
      movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        movieRepository. addMovieDirectorPair(movieName,directorName);
    }
    public static Movie getMovieByName(String searchMovie) {
        return movieRepository.getMovieByName(searchMovie);
    }

    public static Director getDirectorByName(String searchDirector) {
        return movieRepository.getDirectorByName(searchDirector);
    }

    public List<Movie> getMoviesByDirectorName(String director) {
        return (List<Movie>) movieRepository.getMoviesByDirectorName(director);
    }
    public List<Movie> findAllMovies() {
        return movieRepository.findAllMovies();
    }
    public static void deleteDirectorByName(Director searchDirector) {

        movieRepository.deleteDirectorByName(searchDirector.getName());
    }

    public static void deleteAllDirectors(Director searchDirector) {
        movieRepository.deleteAllDirectors();
    }


}
