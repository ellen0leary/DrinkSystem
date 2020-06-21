package Controllers;

import Other.Drinks;
import Other.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static Other.Main.drink;

public class drinksController {
    public static drinksController drinkController;
    public Button Cancel, saveShow;
    public TextField Name,Country,Description;

    /**
     * load the main menu page
     * @param actionEvent
     */
    public void cancel(ActionEvent actionEvent) {
        Main.setMainMenu();
    }

    /**
     * saves the show
     * @param actionEvent
     */
    public void saveShow(ActionEvent actionEvent) {
        String name = Name.getText();
        String country = Country.getText();
        String description = Description.getText();
        drink.add(new Drinks(name,country,description));
        clearFields();
        Main.setMainMenu();
    }

    /**
     * clear all the text field
     */
    private void clearFields() {
        Name.setText("");
        Country.setText("");
        Description.setText("");
    }

    /**
     * updates the drink information
     * @param i
     */
    public void update(int i){
        System.out.println(drink.get(i).toString());
        Name.setText(drink.get(i).getName());
        Country.setText(drink.get(i).getCountry());
        Description.setText(drink.get(i).getDescription());
    }
}