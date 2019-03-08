public class Test {
    public static void main(String[] args) {
        MovieManager database = MovieManager.getInstance();
        RegisteredUser user = testBasicFunctions(database);
        //testComments(database, user);
    }

    public static RegisteredUser testBasicFunctions (MovieManager database) {
        database.addMovie("Spectre", "action", 4, 3, 4, 5, 5, true);

        UnregisteredUser ur = new UnregisteredUser();
        RegisteredUser user = null;
        RegisteredUser result = ur.register("Fabio", ":)");

        if (result != null) {
            user = result;
            user.login("username", "password");
            Movie movie = user.searchMovie("Spectre");
            System.out.println(movie.toString());
            Review review = user.writeReview(movie, "This is testing if review has been created");
            Review review2 = user.writeReview(movie, "This is a completely different review");
            System.out.println(movie);

            user.editReview(movie, review, "This review had its body changed");
            System.out.println(movie);

            user.deleteReview(movie, review);
            System.out.println(movie);
        }

        UnregisteredUser ur2 = new UnregisteredUser();
        RegisteredUser user2 = ur.register("Fabio", ":(");

        return user;
    }
}