package sample;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.collections.ObservableList;
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
    ListView<String> listView;
   public static void main(String[] args) {
        launch(args); // method inside application class
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
       window = primaryStage;
       window.setTitle("ComboBox demo");
       listView = new ListView<>();
       Button button = new Button("Submit");
       listView.getItems().addAll("IRON man", "Titanic", "Contact");
       listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

       button.setOnAction(e->buttonClicked());


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView,button);
        Scene scene = new Scene(layout, 300, 250);

        window.setScene(scene);
        window.show();

    }
    private void buttonClicked(){
       String message = "";
       ObservableList<String> movies;
       movies =listView.getSelectionModel().getSelectedItems();
       for(String m: movies){
           message+=m;
           System.out.print(message);
        }
    }



}
