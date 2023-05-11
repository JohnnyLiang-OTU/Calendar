package Test;

import javafx.application.Application;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Driver extends Application
{
    @Override
    public void start(Stage stage) throws Exception {
        GUI gui = new GUI();
        gui.display();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

