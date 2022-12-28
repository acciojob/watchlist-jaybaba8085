package com.driver;

public class Director extends Movie {
    public  int numberOfMovies;
    public  double imdbRating;
    Director(){}

    public Director(int numberOfMovies, double imdbRating) {
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
