package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    static MovieRepository movieRepository;

    public  void addMovie(Movie movie) {
       movieRepository.addMovie(movie);
    }

    public  void addDirector(Director director) {
      movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        movieRepository.addMovieDirectorPair(movieName,directorName);
    }
    public  Movie getMovieByName(String searchMovie) {
        return movieRepository.getMovieByName(searchMovie);
    }

    public  Director getDirectorByName(String searchDirector) {
        return movieRepository.getDirectorByName(searchDirector);
    }

    public List<String> getMoviesByDirectorName(String director) {
        return (List<String>) movieRepository.getMoviesByDirectorName(director);
    }
    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }
    public static void deleteDirectorByName(Director searchDirector) {

        movieRepository.deleteDirectorByName(searchDirector.getName());
    }

    public static void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }


}
