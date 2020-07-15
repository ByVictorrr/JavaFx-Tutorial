package sample;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {


    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("thenewboston");

        Person bucky = new Person();
        // whenever firstName changes
        bucky.firstNameProperty().addListener((v,oldV, newV)->{
            System.out.println("Name changed to " + newV);
            System.out.println("firstNameProperty(): " + bucky.firstNameProperty());
            System.out.println("getFirstName(): " + bucky.getFirstName());
        });


        button = new Button("Submit");
        button.setOnAction(e->bucky.setFirstName("Porky"));



        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }


}