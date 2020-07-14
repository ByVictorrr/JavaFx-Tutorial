package sample;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.w3c.dom.Text;


public class Main extends Application{

    Stage window;
   public static void main(String[] args) {
        launch(args); // method inside application class
        //stage is window
        // scene stuff inside window
    }

    private boolean isInt(TextField in, String msg){
       try{
          int age = Integer.parseInt(msg);
          System.out.println("User is: " + age);
          return true;
       }catch (NumberFormatException e){
          System.out.print("Error: "+ msg + " is not a number");
          return false;
       }
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
       window = primaryStage;
       // Form
        TextField nameInput = new TextField();
        Button btn = new Button("click me");
        btn.setOnAction(e-> isInt(nameInput, nameInput.getText()));
        window.show();
        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(nameInput, btn);
        Scene scene= new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
       /* Grid Pane
       GridPane grid = new GridPane();
       grid.setPadding(new Insets(10,10,10,10));
       grid.setVgap(8); //sets verticle padding
        grid.setHgap(10);

        // Name label
        Label nameLabel = new Label("Username: ");
        GridPane.setConstraints(nameLabel, 0,  0); // this label occurs at pos (0,0)

        //Name input
        TextField nameIn = new TextField();
        GridPane.setConstraints(nameIn, 1,0);

        // Pass Label
        Label passLabel = new Label("Password: ");
        GridPane.setConstraints(passLabel, 0,  1); // this label occurs at pos (0,0)
        // pass input
        TextField passIn = new TextField();
        passIn.setPromptText("password");
        GridPane.setConstraints(nameIn, 1,1);
        // Login btn
        Button logBtn = new Button("Log in");
        GridPane.setConstraints(logBtn, 1, 2);


        grid.getChildren().addAll(nameLabel, nameIn, passIn, passLabel, logBtn);
        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);
        */
       /* Using Multiple layouts (Border Pane)
        HBox topMenu = new HBox();
        Button btnA = new Button("File");
        Button btnB = new Button("Edit");
        Button btnC = new Button("View");

        topMenu.getChildren().addAll(btnA,btnB,btnC);

        VBox leftMenu = new VBox();
        Button btnD = new Button("D");
        Button btnE = new Button("E");
        Button btnF = new Button("F");
        leftMenu.getChildren().addAll(btnD,btnE,btnF);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);

        Scene scene = new Scene(borderPane, 300, 250);
        window.setScene(scene);
        window.show();
        */


       /* CLosing a window
       window = primaryStage;
       window.setTitle("the victor");
       window.setOnCloseRequest(e->{
           e.consume(); // tells system we are going to take out of it
           closeProgram();
       });
        */
       /* Communicating between windows
       Button btn = new Button("CLICK me");
       btn.setOnAction(e->{
           boolean result = ConfirmBox.display("Title of window", "Are you sure you want to send pics");

       });
       /*
        primaryStage.setTitle("the new boston");;
        Button btn = new Button("close the window");
        btn.setOnAction(e->AlertBox.display("title of window", "Wow this alert box is cool"));



            Change scenes
             Button btn;
             Stage window;
             Scene scene1, scene2;

        window = primaryStage;
        Label label1 = new Label("Welcome to the first scene!");
        Button btn1 = new Button("Go to scene 2");
        btn1.setOnAction(e->window.setScene(scene2));

        // Layout 1 - chiildren are laid out in vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1,btn1);
        scene1 = new Scene(layout1, 200, 200);

        // Button 2
        Button btn2 = new Button("This scene sucks, go back to scene 1");
        btn2.setOnAction(e->window.setScene(scene1));

        // Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(btn2);
        scene2 = new Scene(layout2, 600, 300);

        window.setScene(scene1);
        window.setTitle("Title her");
        window.show();
         */
        /* Handler syntax
        primaryStage.setTitle("Title of the Window");
        btn = new Button("click me"); //button.setText("click me")

        // option 1 - with function
        btn.setOnAction(this); // setup handler in (this) class
        // option 2 - inner class
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               System.out.println("Pressed");
            }
        });
        //option 3 - lambda
        btn.setOnAction(e->System.out.println("lambda pressed"));

        layout.getChildren().add(bu);
        Scene scene = new Scene(layout, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();

         */

    }

    private void closeProgram(){
       System.out.println("File is saved");
       window.close();
    }


}
