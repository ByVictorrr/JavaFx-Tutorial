package sample;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    // properties = help get a listener on a variable
    private StringProperty firstName = new SimpleStringProperty(this, "firstName", ""); //StringProperty is an abstract class

    // Returns the StringProperty object
    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
}
