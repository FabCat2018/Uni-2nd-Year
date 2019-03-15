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
    Review review;

    Stage window;
    Scene registerScene, loginScene, mainScene, movieScene, textScene;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start (Stage primaryStage) throws Exception {
        database.addMovie("Spectre", "Action", 4, 3, 4, 4, 5, true);
        Movie spectre = MovieManager.getInstance().searchMovie("Spectre");
        window = primaryStage;
        final int HEIGHT = 500;
        final int WIDTH = 200;

        /* REGISTER SCENE SECTION */

        //Register Scene Functionality
        Label registerLabel = new Label("Please register your details with us");
        TextField userNameR = new TextField("Create your username here");
        TextField passwordR = new TextField("Create a password here");
        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> {
            user = ur.register(userNameR.getText(), passwordR.getText());
            window.setScene(loginScene);
        });

        //Register Scene Layout
        VBox registerLayout = new VBox(20);
        registerLayout.getChildren().addAll(registerLabel, userNameR, passwordR, registerButton);
        registerScene = new Scene(registerLayout, HEIGHT, WIDTH);

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
                window.setScene(mainScene);
            else
                recognised.setVisible(true);
        });

        //Login Scene Layout
        VBox loginLayout = new VBox(20);
        loginLayout.getChildren().addAll(loginLabel, userNameL, passwordL, recognised, loginButton);
        loginScene = new Scene(loginLayout, HEIGHT, WIDTH);

        /* END OF LOGIN SCENE SECTION */
        

        /* MAIN SCENE SECTION */

        //Main Scene Functionality
        Label mainLabel = new Label("Any reviews-related activities will be for Spectre (Demonstration purposes)");
        Button addReviewButton = new Button("Add Review");
        addReviewButton.setOnAction(e -> {
            body = TextEntry.display("Movie Review Text Entry", "Please enter your review body below");
            if (!body.equals(""))
                review = user.writeReview(spectre, body);
        });

        Button editReviewButton = new Button("Edit Last Added Review");
        editReviewButton.setOnAction(e -> {
            body = TextEntry.display("Movie Review Text Entry", "Please enter your new review body below");
            if (!body.equals("")) {
                if (review == null)
                    user.writeReview(spectre, body);
                else
                    user.editReview(spectre, review, body);
            }
        });

        Button deleteReviewButton = new Button("Delete Last Added Review");
        deleteReviewButton.setOnAction(e -> {
            if (review != null)
                user.deleteReview(spectre, review);
        });

        Button movieButton = new Button("View Movie");
        movieButton.setOnAction(e -> {
            MovieDisplay.display("Spectre Movie Info", spectre);
        });

        //Main Scene Layout
        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().addAll(mainLabel, addReviewButton, editReviewButton, deleteReviewButton, movieButton);
        mainScene = new Scene(mainLayout, HEIGHT, WIDTH);

        /* END OF MAIN SCENE SECTION */


        window.setTitle("Movie Review System");
        window.setScene(registerScene);
        window.show();
    }
}