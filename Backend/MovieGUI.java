import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MovieGUI extends Application {
    /**
     * @param database
     * @param ur
     * @param user
     */

    MovieManager database = MovieManager.getInstance();
    UnregisteredUser ur = new UnregisteredUser();
    RegisteredUser user = null;
    String body;
    int id;
    Review review;

    Stage window;
    Scene registerScene, loginScene, searchScene, mainScene, movieScene, textScene;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start (Stage primaryStage) throws Exception {
        database.addMovie("Spectre", "Action", 4, 3, 4, 4, 5, true);
        Movie spectre = MovieManager.getInstance().searchMovie("Spectre");
        window = primaryStage;
        final int HEIGHT = 250;
        final int WIDTH = 600;

        /* REGISTER SCENE SECTION */

        //Register Scene Functionality
        Label registerLabel = new Label("Please register your details with us");
        TextField userNameR = new TextField("Create your username here");
        TextField passwordR = new TextField("Create a password here");
        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> {
            if (!userNameR.getText().equals("") && !userNameR.getText().equals("Create your username here") && !passwordR.getText().equals("") && !passwordR.getText().equals("Create a password here")) {
                user = ur.register(userNameR.getText(), passwordR.getText());
                window.setScene(loginScene);
            }
        });

        //Register Scene Layout
        VBox registerLayout = new VBox(20);
        registerLayout.getChildren().addAll(registerLabel, userNameR, passwordR, registerButton);
        registerScene = new Scene(registerLayout, WIDTH, HEIGHT);

        /* END OF REGISTER SCENE SECTION */


        /* LOGIN SCENE SECTION */

        //Login Scene Functionality
        Label loginLabel = new Label("Please enter your login details");
        TextField userNameL = new TextField("Enter username here");
        TextField passwordL = new TextField("Enter password here");
        TextField recognised = new TextField("Our apologies, your login or password is incorrect");
        recognised.setVisible(false);
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            boolean correct = user.login(userNameL.getText(), passwordL.getText());
            if (correct)
                window.setScene(searchScene);
            else
                recognised.setVisible(true);
        });

        //Login Scene Layout
        VBox loginLayout = new VBox(20);
        loginLayout.getChildren().addAll(loginLabel, userNameL, passwordL, recognised, loginButton);
        loginScene = new Scene(loginLayout, WIDTH, HEIGHT);

        /* END OF LOGIN SCENE SECTION */


        /* SEARCH MOVIE SECTION */

        //Search Movie Functionality
        Label searchLabel = new Label("Please enter the name of the movie you wish to search for\nDemonstration Purpose, only movie in database is 'Spectre'");
        TextField searchBar = new TextField("");
        TextField nonExistent = new TextField("Our apologies, that movie does not exist in our database");
        nonExistent.setVisible(false);
        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {
            if (searchBar.getText().equals("Spectre"))
                window.setScene(mainScene);
            else
                nonExistent.setVisible(true);

        });

        //Search Movie Layout
        VBox searchLayout = new VBox(20);
        searchLayout.getChildren().addAll(searchLabel, searchBar, nonExistent, searchButton);
        searchScene = new Scene(searchLayout, WIDTH, HEIGHT);

        /* END OF SEARCH MOVIE SECTION */
        

        /* MAIN SCENE SECTION */

        //Main Scene Functionality
        Label mainLabel = new Label("Any reviews-related activities will be for Spectre (Demonstration purposes)");
        Button addReviewButton = new Button("Add Review");
        addReviewButton.setOnAction(e -> {
            body = TextEntry.display("Movie Review Text Entry", "Please enter your review body below");
            if (!body.equals(""))
                review = user.writeReview(spectre, body);
            else
                System.out.println("Try again");
        });

        Button editReviewButton = new Button("Edit Current Review");
        editReviewButton.setOnAction(e -> {
            body = TextEntry.display("Movie Review Text Entry", "Please enter your new review body below");
            if (!body.equals("")) {
                if (review == null)
                    review = user.writeReview(spectre, body);
                else
                    user.editReview(spectre, review, body);
            }
        });

        Button deleteReviewButton = new Button("Delete Current Review");
        deleteReviewButton.setOnAction(e -> {
            if (review != null) {
                user.deleteReview(spectre, review);
                review = null;
                int size = spectre.getReviewsList().size();
                if (size > 0)
                    review = spectre.getReviewsList().get(size-1);
            }
        });

        Button switchReviewButton = new Button("Switch Current Review");
        switchReviewButton.setOnAction(e -> {
            if (spectre.getReviewsList().size() > 0) {
                id = SwitchingWindow.display("Switch Current Review", "Enter the number of the review to switch to (1 is the first review in the list)");
                review = spectre.getReviewsList().get(id-1);
            }
        });

        Button movieButton = new Button("View Movie");
        movieButton.setOnAction(e -> {
            MovieDisplay.display("Spectre Movie Info", spectre);
        });

        //Main Scene Layout
        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().addAll(mainLabel, addReviewButton, editReviewButton, deleteReviewButton, switchReviewButton, movieButton);
        mainScene = new Scene(mainLayout, WIDTH, HEIGHT);

        /* END OF MAIN SCENE SECTION */


        window.setTitle("Movie Review System");
        window.setScene(registerScene);
        window.show();
    }
}