package Test;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.LightBase;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class FormWindow {
    public static void displayForm(int dayNumber)
    {
        Stage windowForm = new Stage();
        windowForm.initModality(Modality.APPLICATION_MODAL);
        windowForm.setTitle("Form");

        GridPane layoutInfo = new GridPane();
        layoutInfo.setAlignment(Pos.CENTER);
        layoutInfo.setVgap(10);
        layoutInfo.setHgap(3);
        //Label and Buttons Declarations
        Label durationLabel = new Label("Duration(hours):");
        TextField durationForm = new TextField();
        Label descriptionLabel = new Label("Description:");
        TextField descriptionForm = new TextField();
        ComboBox<String> comboBox = new ComboBox<>();
        for(int i = 0; i <= 24; i++)
        {
            int hour = i / 2;
            int minute = (i % 2) * 30;
            String time = String.format("%02d:%02d", hour, minute);
            comboBox.getItems().add(time);
        }
        comboBox.setValue(comboBox.getItems().get(0));

        // Add combo box to choose times and then use the input to create a new Entry object in the handle function.
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String userSelection = comboBox.getValue();
                int hour = Integer.parseInt(userSelection.substring(0, 2));
                int minute = Integer.parseInt(userSelection.substring(3));
                LocalDateTime ldate = LocalDate.now().atTime(hour, minute);
                int duration = Integer.parseInt(durationForm.getText());
                String description = descriptionForm.getText();
                Entry entry = new Entry(ldate, duration, description); //
                Calendar.addEvent(entry);
                windowForm.close();
            }
        });
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> windowForm.close());

        layoutInfo.add(durationLabel, 0, 0);
        layoutInfo.add(durationForm, 1, 0);
        layoutInfo.add(new Label("Start"), 0, 1);
        layoutInfo.add(comboBox, 1, 1);
        layoutInfo.add(descriptionLabel, 0, 2);
        layoutInfo.add(descriptionForm, 1, 2);
        layoutInfo.add(submitButton, 0, 3);
        layoutInfo.add(closeButton, 1, 3);
        GridPane.setHalignment(closeButton, HPos.CENTER);

        Scene mainScene = new Scene(layoutInfo, 250, 250);
        windowForm.setScene(mainScene);

        windowForm.showAndWait();
    }
}
