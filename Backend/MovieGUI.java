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

    Stage window;
    Scene registerScene, loginScene, mainScene, movieScene, textScene;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start (Stage primaryStage) throws Exception {
        database.addMovie("Spectre", "Action", 4, 3, 4, 4, 5, true);
        window = primaryStage;

        /* REGISTER SCENE SECTION */

        //Register Scene Functionality
        Label registerLabel = new Label("Please register your details with us");
        TextField userNameR = new TextField();
        TextField passwordR = new TextField();
        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> {
            user = ur.register(userNameR.getText(), passwordR.getText());
            window.setScene(loginScene);
        });

        //Register Scene Layout
        VBox registerLayout = new VBox(20);
        registerLayout.getChildren().addAll(registerLabel, userNameR, passwordR, registerButton);
        registerScene = new Scene(registerLayout, 300, 200);

        /* END OF REGISTER SCENE SECTION */


        /* LOGIN SCENE SECTION */

        //Login Scene Functionality
        Label loginLabel = new Label("Please enter your login details");
        TextField userNameL = new TextField();
        TextField passwordL = new TextField();
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            user.login(userNameL.getText(), passwordL.getText());
            window.setScene(mainScene);
        });

        //Login Scene Layout
        VBox loginLayout = new VBox(20);
        loginLayout.getChildren().addAll(loginLabel, userNameL, passwordL, loginButton);
        loginScene = new Scene(loginLayout, 300, 200);

        /* END OF LOGIN SCENE SECTION */
        

        /* MAIN SCENE SECTION */

        //Main Scene Functionality

        //Main Scene Layout

        /* END OF MAIN SCENE SECTION */


        /* MOVIE SCENE SECTION */
      
        //Movie Scene Functionality

        //Movie Scene Layout

        /* END OF MOVIE SCENE SECTION */


        /* TEXT SCENE SECTION */

        //Text Scene Functionality--used for add and edit

        //Text Scene Layout

        /* END OF TEXT SCENE SECTION */


        window.setTitle("Movie Review System");
        window.setScene(registerScene);
        window.show();
    }
}