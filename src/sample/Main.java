package sample;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Main extends Application{
    Stage window;
   public static void main(String[] args) {
        launch(args); // method inside application class
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
       window = primaryStage;
       window.setTitle("Choice Box demo");
       Button button = new Button("Click me");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        // getItems return the ObservableList object which you can add items to
        choiceBox.getItems().add("Apple");
        choiceBox.getItems().add("Banna");
        choiceBox.getItems().addAll("Bacon", "Ham", "Meatball");
        // set default value
        choiceBox.setValue("Apple");
        // Listen for selection changes
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldVal, newVal)->{
            System.out.print(newVal);
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(choiceBox,button);
        Scene scene = new Scene(layout, 300, 250);

        window.setScene(scene);
        window.show();

    }
    // To get the value of the selected item
    private void getChoice(ChoiceBox<String> box){
      String food = box.getValue();
      System.out.print(food);
    }



}
