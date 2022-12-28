package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

//    Add a movie: POST /movies/add-movie
//    Pass the Movie object as request body
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addMovie
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie)
    {
        //code here
        movieService.addMovie(movie);

        return new ResponseEntity<>("Movie added successfully", HttpStatus.CREATED);
    }

//    Add a director: POST /movies/add-director
//    Pass the Director object as request body
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addDirector
@PostMapping("/movies/add-director")
public ResponseEntity<String> addDirector(@RequestBody() Director director)
{
    movieService.addDirector(director);
    return new ResponseEntity<>("Director added successfully", HttpStatus.CREATED);
}


//    Pair an existing movie and director: PUT /movies/add-movie-director-pair
//    Pass movie name and director name as request parameters
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addMovieDirectorPair
@PutMapping("/movies/add-movie-director-pair")
public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName, @RequestParam String directorName) {
    movieService.addMovieDirectorPair(movieName, directorName);
    return new ResponseEntity<>("Movie-director pair added successfully", HttpStatus.ACCEPTED);
}


//    Get Movie by movie name: GET /movies/get-movie-by-name/{name}
//    Pass movie name as path parameter
//    Return Movie object wrapped in a ResponseEntity object
//    Controller Name - getMovieByName
@GetMapping("/movies/get-movie-by-name/{name}")
public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {

    Movie movie = movieService.getMovieByName(name);
    if (movie == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
}


//    Get Director by director name: GET /movies/get-director-by-name/{name}
//    Pass director name as path parameter
//    Return Director object wrapped in a ResponseEntity object
//    Controller Name - getDirectorByName
@GetMapping("/movies/get-director-by-name/{name}")
public ResponseEntity<Director> getDirectorByName(@PathVariable String name) {
    Director director = movieService.getDirectorByName(name);
    if (director == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
        return new ResponseEntity<>(director, HttpStatus.OK);
    }
}


//    Get List of movies name for a given director name: GET /movies/get-movies-by-director-name/{director}
//    Pass director name as path parameter
//    Return List of movies name(List()) wrapped in a ResponseEntity object
//    Controller Name - getMoviesByDirectorName

@GetMapping("/movies/get-movies-by-director-name/{director}")
public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathVariable String director) {
    List<Movie> movies = (List<Movie>) movieService.getMoviesByDirectorName(director);
    if (movies.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}


    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies() {
        List<Movie> movies = movieService.findAllMovies();
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }
    }
//    Delete a director and its movies from the records: DELETE /movies/delete-director-by-name
//    Pass director’s name as request parameter
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - deleteDirectorByName
@DeleteMapping("/movies/delete-director-by-name")
public ResponseEntity<String> deleteDirectorByName(@RequestParam("id")Director searchDirector)
{
    MovieService.deleteDirectorByName(searchDirector);
    return new ResponseEntity<>(  "The Director has been deleted" , HttpStatus.OK);
}

//    Delete all directors and all movies by them from the records: DELETE /movies/delete-all-directors
//    No params or body required
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - deleteAllDirectors
//            (Note that there can be some movies on your watchlist that aren’t mapped to any of the director. Make sure you do not remove them.)
@DeleteMapping("/movies/delete-director-by-name")
public ResponseEntity<String> deleteAllDirectors(@RequestParam("id")Director searchDirector)
{
    MovieService.deleteAllDirectors(searchDirector);

    return new ResponseEntity<>(  "The all Director has been deleted" , HttpStatus.OK);
}
}
