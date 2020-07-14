package sample;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application{
    Stage window;
    ComboBox<String> comboBox;
   public static void main(String[] args) {
        launch(args); // method inside application class
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
       window = primaryStage;
       window.setTitle("ComboBox demo");
       Button button = new Button("Click me");

       comboBox = new ComboBox<>();
       comboBox.getItems().addAll(
               "Good will Hunting",
                "St. vincent",
               "Blackhat"
       );

       // Combo box doesnt need prompt text in the list
       comboBox.setPromptText("What is your favorite movie?");
       button.setOnAction(e->printMovie());

       // occurs when selected
       comboBox.setOnAction(e -> System.out.print("User selected: "+ comboBox.getValue()));
       // Option to write in own movies
       comboBox.setEditable(true);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(comboBox,button);
        Scene scene = new Scene(layout, 300, 250);

        window.setScene(scene);
        window.show();

    }
    // To get the value of the selected item
    private void printMovie(){
       System.out.print(comboBox.getValue());
    }



}
