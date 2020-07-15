package sample;

import javafx.scene.control.Button;

/* Behind the schemes of the .fxml file (breaks up view and logic) */
public class Controller {
    // Dont have to assign it if already in fxml
    public Button button;

    public void handleButtonClick(){
        System.out.println("Run some code the user doesnt see");
        button.setText("Steop touching me!");
    }
}
