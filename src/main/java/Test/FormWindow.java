package Test;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class FormWindow {
    public static void displayForm()
    {
        Stage windowForm = new Stage();
        windowForm.initModality(Modality.APPLICATION_MODAL);
        windowForm.setTitle("Form");

        GridPane layoutInfo = new GridPane();
        layoutInfo.setAlignment(Pos.CENTER);
        layoutInfo.setVgap(10);
        layoutInfo.setHgap(3);

        Label descriptionLabel = new Label("Description");
        TextField descriptionForm = new TextField();

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> System.out.println(descriptionForm.getText()));
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> windowForm.close());

        layoutInfo.add(descriptionLabel, 0, 0);
        layoutInfo.add(descriptionForm, 1, 0);
        layoutInfo.add(submitButton, 0, 1);
        layoutInfo.add(closeButton, 1, 1);
        GridPane.setHalignment(closeButton, HPos.CENTER);

        Scene mainScene = new Scene(layoutInfo, 250, 250);
        windowForm.setScene(mainScene);

        windowForm.showAndWait();
    }
}
