import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SwitchingWindow {
    static int reviewId;

    public static int display (String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        TextField newId = new TextField();

        Button switchButton = new Button("Switch");
        switchButton.setOnAction(e -> {
            if (!(newId.getText() == null) && !newId.getText().equals("") && !newId.getText().equals("0"))
                reviewId = Integer.parseInt(newId.getText());
            window.close();
        });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, newId, switchButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return reviewId;
    }
}