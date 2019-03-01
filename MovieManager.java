import java.util.ArrayList;

public class MovieManager {
    private static MovieManager instance = null;
    private ArrayList<Movie> moviesList = new ArrayList<Movie>();
    
    private MovieManager () {}

    public static MovieManager getInstance () {
        if (instance == null)
            instance = new MovieManager();
        return instance;
    }

    public Movie searchMovie (String name) {
        Movie searchedMovie = null;
        for (int i = 0; i < this.moviesList.length(); i++) {
            if (name.equalsIgnoreCase(this.moviesList.get(i).getName()))
                searchedMovie = this.moviesList.get(i);
        }
        return searchedMovie;
    }

    public boolean addMovie (String name, String genre, int actingRating, int cinematographyRating, int conceptRating, int soundtrackRating, int plotRating) {
        Movie newMovie = new Movie(name, genre, actingRating, cinematographyRating, conceptRating, soundtrackRating, plotRating);
        return this.moviesList.add(newMovie);
    }

    public boolean editMovie (Movie movie) {
        switch (option) {
            case "na":
                movie.editName(newName);
            case "ge":
                movie.editGenre(newGenre);
            case "ac":
                movie.editActingRating(newRating);        
            case "co":
                movie.editConceptRating(newRating);
            case "ci":
                movie.editCinematographyRating(newRating);
            case "so":
                movie.editSoundtrackRating(newRating);
            default:
                movie.editPlotRating(newRating);
        }

    }

    public boolean removeMovie (Movie movie) {
        return this.moviesList.remove(movie);
    }

    public ArrayList<Movie> getMoviesList () {
        return this.moviesList;
    }
}