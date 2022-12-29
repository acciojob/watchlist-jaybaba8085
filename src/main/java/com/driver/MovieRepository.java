package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

       HashMap<String, Movie> movies = new HashMap<>();
       HashMap<String, Director> directors = new HashMap<>();
     //  HashMap<Movie,Director>pair= new HashMap<>();
  public   HashMap<String,List<String>>pair=new HashMap<>();
    public void addMovie(Movie movie) {   movies.put(movie.getName(),movie);   }
    public void addDirector(Director director) {
        String name=director.name;
        directors.put(name, director); //director.getName()
    }
    public void addMovieDirectorPair(String movieName, String directorName)
    {
        //Movie movie = movies.get(movieName);
       // Director director = directors.get(directorName);
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
//6
    public List<String> getMoviesByDirectorName(String directorName) {
         List<String>ls= new ArrayList<>();
         if(pair.containsKey(directorName))
         {
             for(String s : pair.get(directorName))
             {
                 ls.add(s);
             }
         }
       return ls ;
    }
    public List<String> findAllMovies() {
        List<String>ls= new ArrayList<>();
        for(String name:movies.keySet())
        {
            ls.add(name);
        }
        return new ArrayList<>(ls);
    }
    //8
    public void deleteDirectorByName(String director) {

         // directors.remove(director);
          pair.remove(director);
    }
    //9
    public  void deleteAllDirectors() {
        directors.clear();
    }
}
