import java.util.ArrayList;
import java.util.Scanner;

public class MovieManager {
    private static MovieManager instance = null;
    private ArrayList<Movie> moviesList = new ArrayList<Movie>();

    //Modified admin-only methods to check isAdmin

    private MovieManager () {}

    public static MovieManager getInstance () {
        if (instance == null)
            instance = new MovieManager();
        return instance;
    }

    public Movie searchMovie (String name) {
        Movie searchedMovie = null;
        for (int i = 0; i < this.moviesList.size(); i++) {
            if (name.equalsIgnoreCase(this.moviesList.get(i).getName()))
                searchedMovie = this.moviesList.get(i);
        }
        return searchedMovie;
    }

    public void addMovie (String name, String genre, int actingRating, int cinematographyRating, int conceptRating, int soundtrackRating, int plotRating, boolean isAdmin) {
        if (isAdmin) {
            Movie newMovie = new Movie(name, genre, actingRating, cinematographyRating, conceptRating, soundtrackRating, plotRating);
            this.moviesList.add(newMovie);
            return;
        }
        System.out.println("Only Admin can perform this action");
    }

    public void editMovie (Movie movie, boolean isAdmin) {
        String newName = "";
        String newGenre = "";
        int newRating;

        if (isAdmin) {
            String option = this.input("What would you like to edit? (Please enter the first two characters, e.g. name=na):");
            switch (option) {
                case "na":
                    newName = input("Enter new name: ");
                    movie.editName(newName);
                case "ge":
                    newGenre = input("Enter new genre: ");
                    movie.editGenre(newGenre);
                case "ac":
                    newRating = inputInt("Enter new rating: ");
                    movie.editActingRating(newRating);        
                case "co":
                    newRating = inputInt("Enter new rating: ");
                    movie.editConceptRating(newRating);
                case "ci":
                    newRating = inputInt("Enter new rating: ");
                    movie.editCinematographyRating(newRating);
                case "so":
                    newRating = inputInt("Enter new rating: ");
                    movie.editSoundtrackRating(newRating);
                case "pl":
                    newRating = inputInt("Enter new rating: ");
                    movie.editPlotRating(newRating);
                default:
                    System.out.println("Invalid response. Please use the first two characters of the movie attribute you'd like to change.");
            }
            return;
        }
        System.out.println("Only Admin can perform this action");

    }

    public void removeMovie (Movie movie, boolean isAdmin) {
        if (isAdmin) {
            this.moviesList.remove(movie);
            return;
        }
        System.out.println("Only Admin can perform this action");
        
    }

    public ArrayList<Movie> getMoviesList () {
        return this.moviesList;
    }

    private String input (String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    private int inputInt (String message) {
        return Integer.parseInt(input(message));
    }
}