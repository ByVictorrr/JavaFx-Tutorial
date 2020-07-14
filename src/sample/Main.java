package sample;

import com.sun.source.tree.Tree;
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
    TreeView<String> tree;
   public static void main(String[] args) {
        launch(args); // method inside application class
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
       window = primaryStage;
       window.setTitle("ComboBox demo");
       TreeItem<String> root, bucky, megan;
       // root
        root = new TreeItem<>();
        root.setExpanded(true);

        // bucky
        bucky = makeBranch("Bucky", root);
        makeBranch("thenewboston", bucky);
        makeBranch("Youtube", bucky);

        // megan
        megan = makeBranch("Megan", root);
        makeBranch("tiktok", megan);
        makeBranch("Youtube", megan);

        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((v,o,n)->{
            if (n!=null){
                System.out.print(n);
            }
        });


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(tree);
        Scene scene = new Scene(layout, 300, 250);

        window.setScene(scene);
        window.show();

    }
    private TreeItem<String> makeBranch(String child, TreeItem<String> parent){
        TreeItem<String>i = new TreeItem<>(child);
        i.setExpanded(true);
        parent.getChildren().add(i);
        return i;
    }



}
