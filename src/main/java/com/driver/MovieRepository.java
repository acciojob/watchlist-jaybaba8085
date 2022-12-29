package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

       HashMap<String, Movie> movies = new HashMap<>();
       HashMap<String, Director> directors = new HashMap<>();
       HashMap<String,List<String>>pair=new HashMap<>();


    public void addMovie(Movie movie) {
        String name=movie.getName();
        movies.put(name,movie);
    }

    public void addDirector(Director director) {
        String name=director.getName();
        directors.put(name, director); //director.getName()

    }
    public void addMovieDirectorPair(String movieName, String directorName)
    {
       if(pair.containsKey(directorName))
       {
           pair.get(directorName).add(movieName);
       }
       else{
           List<String> ls= new ArrayList<>();
           ls.add(movieName);
           pair.put(directorName,ls);
       }
    }
    public Movie getMovieByName(String name) {
        return movies.get(name);
    }

    public Director getDirectorByName(String name) {
        Director d=new Director();
        if(directors.containsKey(name))
            d=directors.get(name);
        return  d;
    }

    public List<String> findAllMovies() {
        List<String>ls= new ArrayList<>();
        for(String name:movies.keySet())
        {
            ls.add(name);
        }
        return new ArrayList<>(ls);
    }
    //6
    public List<String> getMoviesByDirectorName(String directorName)
    {
        List<String>ls= new ArrayList<>();
        if(pair.containsKey(directorName)) return pair.get(directorName);
         return null;

    }
    //8
    public String deleteDirectorByName(String directorName) {

        if(directors.containsKey(directorName)){
            if(pair.containsKey(directorName)){
                List<String>moviess=pair.get(directorName);
                        for(String moviee:moviess)
                        {if(movies.containsKey(moviee))
                            {movies.remove(moviee);}
                        }
                directors.remove(directorName);
                pair.remove(directorName);
                return "Removed SuccessFully";
            }
        }return "Director DNE!!";
    }
    //9
    public  void deleteAllDirectors() {
        directors.clear();
    }
}
