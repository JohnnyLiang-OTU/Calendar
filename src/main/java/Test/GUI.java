package Test;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import java.time.DayOfWeek;
import java.time.LocalDate;


public class GUI{
    final double WIDTH = 120;
    final double HEIGHT_WEEKDAY = 10;
    public void display()
    {
        Stage window = new Stage();
        GridPane layout = new GridPane();
        layout.setHgap(5);
        layout.setVgap(5);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        for(int i = 0; i < 7; i++) // Adds the weekdays at the top of the grid.  WANT TO MAKE THIS INTO A FUNCTION - displayWeekdays()
        {
            Label label = new Label(DayOfWeek.of(i+1).toString());
            label.setStyle("-fx-font-weight: bold");
            label.setPrefSize(WIDTH, HEIGHT_WEEKDAY);
//            GridPane.setConstraints(label, i, 0); // item , column, row
            layout.add(label, i, 0);
            label.setAlignment(Pos.CENTER);
        }

        // WANT TO MAKE THIS INTO A FUNCTION - displayButtons()

        // Variables needed for the forloop logic.
        LocalDate firstDayOfMonth = LocalDate.now().withDayOfMonth(1); // Goes from current date to current date with day at 1. (2023-05-10 -> 2023-05-01)
        int daysInMonth = LocalDate.now().lengthOfMonth();             // How many days in a month
        int dayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();     // Gets the weekday of the first day of month.

        for(int j = 1; j <= daysInMonth; j++)
        {
            final int holder = j;
            Button button = new Button(Integer.toString(j));
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    FormWindow.displayForm(holder);
                }
            });

            int row = (j + dayOfWeek - 2) / 7 + 1;
            int col = (j + dayOfWeek - 2) % 7;
            layout.add(button, col, row);                             // Adding button
            GridPane.setHalignment(button, HPos.CENTER);              // Centering button
        }

        layout.setGridLinesVisible(true);
        Scene scene = new Scene(layout, 700, 500);

        window.setScene(scene);
        window.setTitle("Testing");
        window.show();
    }
}

