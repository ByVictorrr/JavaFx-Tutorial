package sample;

import com.sun.source.tree.Tree;
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
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;

   public static void main(String[] args) {
        launch(args); // method inside application class
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
       window = primaryStage;
       window.setTitle("ComboBox demo");

       // Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name")); // tie data together

        // Price Column
        TableColumn<Product, String> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("price")); // tie data together

        // Price Column
        TableColumn<Product, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(200);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("quantity")); // tie data together

        // Name input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        // Price input
        priceInput = new TextField();
        priceInput.setPromptText("price");
        // Price input
        quantityInput = new TextField();
        quantityInput.setPromptText("quantity");

        // Btn
        Button addBtn = new Button("add");
        Button delBtn = new Button("delete");
        addBtn.setOnAction(e->addBTNClicked());
        delBtn.setOnAction(e->delBTNClicked());

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setSpacing(10);
        hbox.getChildren().addAll(nameInput,priceInput,quantityInput,addBtn,delBtn);




        table = new TableView<>();
        table.setItems(getProduct());

        table.getColumns().addAll(priceColumn, nameColumn, quantityColumn);



        VBox layout = new VBox(10);
        layout.getChildren().addAll(table, hbox);
        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();

    }
    private void addBTNClicked(){
       Product p=new Product(nameInput.getText(), Double.parseDouble(priceInput.getText()), Integer.parseInt(quantityInput.getText()));
       table.getItems().add(p);
       nameInput.clear();
       priceInput.clear();
       quantityInput.clear();
    }
    private void delBTNClicked(){
      ObservableList<Product> prodSelected, allProducts;
      allProducts = table.getItems();
      prodSelected = table.getSelectionModel().getSelectedItems();

      prodSelected.forEach(allProducts::remove);
    }

    // Get all of the products
    public ObservableList<Product> getProduct(){
        ObservableList<Product> p = FXCollections.observableArrayList();
        p.add(new Product("Laptop", 859.00, 20));
        p.add(new Product("Bouncy ball", 2.00, 20));
        p.add(new Product("Toilet", 99.00, 20));
        p.add(new Product("Corn", 1.40, 20));
        return p;
    }



}
