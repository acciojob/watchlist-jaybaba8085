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
    //1
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie)
    {
        //code here
        movieService.addMovie(movie);

        return new ResponseEntity<>("Movie added successfully", HttpStatus.CREATED);
    }
//2
@PostMapping("/movies/add-director")
public ResponseEntity<Director> addDirector(@RequestBody() Director director)
{
    Director d= movieService.addDirector(director);
    return new ResponseEntity<>(d, HttpStatus.CREATED);
//    "Director added successfully"
}








//3
@PutMapping("/movies/add-movie-director-pair")
public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName, @RequestParam String directorName) {
    movieService.addMovieDirectorPair(movieName, directorName);
    return new ResponseEntity<>("Movie-director pair added successfully", HttpStatus.ACCEPTED);
}






//4
@GetMapping("/movies/get-movie-by-name/{name}")
public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {

    Movie movie = movieService.getMovieByName(name);
    if (movie == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
}


//5
@GetMapping("/movies/get-director-by-name/{name}")
public ResponseEntity<Director> getDirectorByName(@PathVariable String name) {
    Director director = movieService.getDirectorByName(name);
    if (director == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
        return new ResponseEntity<>(director, HttpStatus.OK);
    }
}

//6
@GetMapping("/movies/get-movies-by-director-name/{director}")
public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director) {
    List<String> movies = (List<String>) movieService.getMoviesByDirectorName(director);
    if (movies.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}

//7
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
        List<String> movies = movieService.findAllMovies();
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }
    }
//8
@DeleteMapping("/movies/delete-director-by-name")
public ResponseEntity<String> deleteDirectorByName(@RequestParam("id")Director searchDirector)
{
    MovieService.deleteDirectorByName(searchDirector);
    return new ResponseEntity<>(  "The Director has been deleted" , HttpStatus.OK);
}
//9
@DeleteMapping("/movies/delete-all-directors")
public ResponseEntity<String> deleteAllDirectors()
{
    MovieService.deleteAllDirectors();
    return new ResponseEntity<>(  "The all Director has been deleted" , HttpStatus.OK);
}
}











