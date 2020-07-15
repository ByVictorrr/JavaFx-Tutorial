package sample;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application{
    Stage window;
    BorderPane layout;

   public static void main(String[] args) {
        launch(args); // method inside application class
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
       window = primaryStage;
       window.setTitle("ComboBox demo");
       //File Menu
        Menu fileMenu = new Menu("File");
        // Menu items
        MenuItem newFile = new MenuItem("New ...");
        newFile.setOnAction(e->System.out.print("hi"));
        fileMenu.getItems().add(new MenuItem("Save ..."));
        fileMenu.getItems().add(new MenuItem("Open ...")); // ... means it has a submenu
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings ..."));
        fileMenu.getItems().add(new MenuItem("Exit"));
        fileMenu.getItems().add(newFile);

        // Edit menu
        Menu editMenu = new Menu("_Edit"); // "_" underscore makes so u can use shortcuts
        editMenu.getItems().add(new MenuItem("Copy"));
        editMenu.getItems().add(new MenuItem("Cut"));
        MenuItem paste = new MenuItem("Paste");
        paste.setDisable(false); // not able to select it
        editMenu.getItems().add(paste);

        /* HOW can we toggle a menu Item? */

        // Help menu
        Menu helpMenu = new Menu("Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(e->{
             if(showLines.isSelected()){
               System.out.println("Program will display line numbers now");
             }else{
                 System.out.println("Hiding line numbers");
             }
        });
        CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
        autoSave.setSelected(true); // start of program have it checked

        helpMenu.getItems().addAll(showLines, autoSave);

        // Difficulty RadioMenuItems
        Menu diffMenu = new Menu("Difficulty");
        ToggleGroup diffToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("easy");
        RadioMenuItem medium = new RadioMenuItem("medium");
        RadioMenuItem hard = new RadioMenuItem("hard");
        diffMenu.getItems().addAll(easy, medium, hard);

        easy.setToggleGroup(diffToggle);
        medium.setToggleGroup(diffToggle);
        hard.setToggleGroup(diffToggle);

        // Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, diffMenu);



        layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout, 400, 300);




        window.setScene(scene);
        window.show();

    }


}
