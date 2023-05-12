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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import java.time.DayOfWeek;
import java.time.LocalDate;


public class GUI{
    final double WIDTH = 120;
    final double HEIGHT_WEEKDAY = 10;
    int[] monthDir = {0};
    public void display()
    {
        // Creation and Adjustments of Stage and Gridpane
        Stage window = new Stage();
        HBox switchLayout = new HBox();
        GridPane calendarLayout = new GridPane();
        VBox layoutHolder = new VBox();
        calendarLayout.setHgap(5);
        calendarLayout.setVgap(5);
        calendarLayout.setPadding(new Insets(10));
        calendarLayout.setAlignment(Pos.CENTER);

        displaySwitchButtons(switchLayout, calendarLayout); // Displays the buttons to switch months

        displayDaysText(calendarLayout); // displays the weekDays Text

        displayButtons(calendarLayout); // displays the buttons of each day in the month.

        layoutHolder.getChildren().addAll(switchLayout, calendarLayout);

        //  Creation of Scene, and adjustments of the Gridpane (layout) and Stage (window)
        Scene scene = new Scene(layoutHolder, 700, 500);

        window.setScene(scene);
        window.setTitle("Testing");
        window.show();
    }
    public void displayDaysText(GridPane calendarLayout)
    {
        for(int i = 0; i < 7; i++)
        {
            Label label = new Label(DayOfWeek.of(i+1).toString());
            label.setStyle("-fx-font-weight: bold");
            label.setPrefSize(WIDTH, HEIGHT_WEEKDAY);
            calendarLayout.add(label, i, 0);
            label.setAlignment(Pos.CENTER);
        }
    }

    public void displayButtons(GridPane calendarLayout)
    {
        // Variables needed for the forloop logic.
        LocalDate now = LocalDate.now();
        now = now.plusMonths(monthDir[0]);
        LocalDate firstDayOfMonth = now.withDayOfMonth(1); // Goes from current date to current date with day at 1. (2023-05-10 -> 2023-05-01)

        int daysInMonth = now.lengthOfMonth();             // How many days in a month
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
            calendarLayout.add(button, col, row);                             // Adding button
            GridPane.setHalignment(button, HPos.CENTER);              // Centering button
        }
    }

    public void displaySwitchButtons(HBox switchLayout, GridPane calendarLayout)
    {
        Button prevMonth = new Button("<");
        prevMonth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                calendarLayout.getChildren().clear();
                displayDaysText(calendarLayout);
                monthDir[0]--;
                displayButtons(calendarLayout);
            }
        });

        Button nextMonth = new Button(">");
        nextMonth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                calendarLayout.getChildren().clear();
                displayDaysText(calendarLayout);
                monthDir[0]++;
                displayButtons(calendarLayout);
            }
        });

        switchLayout.getChildren().addAll(prevMonth, nextMonth);
        prevMonth.setAlignment(Pos.CENTER_LEFT);
        nextMonth.setAlignment(Pos.CENTER_RIGHT);
    }
}

