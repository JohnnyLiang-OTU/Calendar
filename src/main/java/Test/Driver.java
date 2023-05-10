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
        Calendar calendar = new Calendar();
        Entry entry1 = new Entry(LocalDate.of(0, 1, 10), 10);
//        System.out.println(entry1.toString());
        Entry entry2 = new Entry(LocalDate.of(0, 1, 21), 10);
//        System.out.println(entry1.within(entry2));
        calendar.addEvent(entry1);
        calendar.addEvent(entry2);
        launch(args);
    }
}

