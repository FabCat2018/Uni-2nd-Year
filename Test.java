public class Test {
    public static void main(String[] args) {
        MovieManager database = MovieManager.getInstance();
        database.addMovie("Spectre", "action", 4, 3, 4, 5, 5, true);

        UnregisteredUser ur = new UnregisteredUser();
        RegisteredUser user;
        RegisteredUser result = ur.register("Fabio", ":)");

        if (result != null) {
            user = result;
            user.login("username", "password");
            Movie movie = user.searchMovie("Spectre");
            System.out.println(movie.toString());
            Review review = user.writeReview(movie, "This is testing if review has been created");
            System.out.println(movie);

            user.editReview(movie, review, "This is a different review");
            System.out.println(movie);

            user.deleteReview(movie, review);
            System.out.println(movie);
        }

        UnregisteredUser ur2 = new UnregisteredUser();
        RegisteredUser user2 = ur.register("Fabio", ":(");
    }
}