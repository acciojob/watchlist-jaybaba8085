package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

     HashMap<String, Movie> movies = new HashMap<>();
     HashMap<String, Director> directors = new HashMap<>();
     HashMap<Movie,Director>pair= new HashMap<>();
    public void addMovie(Movie movie) { movies.put(movie.getName(), movie);  }
    public Director addDirector(Director director) {
        directors.put(director.getName(), director);
        return director;
    }
    public void addMovieDirectorPair(String movieName, String directorName)
    {
        Movie movie = movies.get(movieName);
        Director director = directors.get(directorName);

        pair.put(movie,director);
    }
    public Movie getMovieByName(String name) {
        return movies.get(name);
    }
    public Director getDirectorByName(String name) {
        Director d= directors.get(name);
        return  d;
    }

    public List<String> getMoviesByDirectorName(String director) {
        List<String> moviesByDirector = new ArrayList<>();
        for (Movie d:pair.keySet())
            {
                if(pair.get(d).getName().equals(director))
                moviesByDirector.add((d).getName());
            }
        return moviesByDirector;
    }
    public List<String> findAllMovies() {
        List<String>ls= new ArrayList<>();
        for(String name:movies.keySet())
        {
            ls.add(name);
        }
        return new ArrayList<>(ls);
    }
    public void deleteDirectorByName(String name) {
        directors.remove(name);
    }
    public  void deleteAllDirectors() {
        directors.clear();
    }
}
