import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MovieGUI extends Application implements EventHandler<ActionEvent> {
    /**
     * @param database
     * @param ur
     * @param user
     */

    Button loginButton = new Button("Login");
    Button registerButton = new Button("Register");
    Button addButton = new Button("Add Review to 'Spectre'");
    Button editButton = new Button("Edit Review");
    Button deleteButton = new Button("Delete Review");

    MovieManager database = MovieManager.getInstance();

    UnregisteredUser ur = new UnregisteredUser();
    RegisteredUser user = null;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start (Stage primaryStage) throws Exception {
        database.addMovie("Spectre", "Action", 4, 3, 4, 4, 5, true);
        primaryStage.setTitle("Movie Review System");

        StackPane layout = new StackPane();
        layout.getChildren().add(registerButton);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle (ActionEvent event) {
        if (event.getSource() == registerButton)
            user = ur.register(userName, password);
        if (event.getSource() == loginButton)
            user.login(userName, password);
        if (event.getSource() == addButton && user != null) {
            Movie movie = user.searchMovie("Spectre");
            System.out.println(movie.toString());
            Review review = user.writeReview(movie, "This is testing if review has been created");
        }
        if (event.getSource() == editButton)
            user.editReview(movie, review, "This review had its body changed");
        if (event.getSource() == deleteButton)
            user.deleteReview(movie, review);
    }
}