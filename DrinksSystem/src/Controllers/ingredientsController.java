package Controllers;


import Other.Ingredients;
import Other.Main;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static Other.Main.ingredient;


public class ingredientsController {
    public static ingredientsController ingredientController;
    public Button Cancel, ingredientsSaveButton;
    public TextArea ingredientsDescription;
    public TextField abvContent,ingredientName;

    /**
     * loads the main menu page
     * @param actionEvent
     */
    public void Cancel(javafx.event.ActionEvent actionEvent) {
        Main.setMainMenu();
    }

    /**
     * save the ingredient to a list
     * @param actionEvent
     */
    public void ingredientsSaveButton(javafx.event.ActionEvent actionEvent) {
        String name = ingredientName.getText();
        String description = ingredientsDescription.getText();
        int ABV = Integer.parseInt(abvContent.getText());
        ingredient.add(new Ingredients(name,description,ABV));
        Main.setMainMenu();
        clearField();
        for (Ingredients s : ingredient) {
            System.out.println(s.getName());
        }
    }

    /**
     * clears all the fields
     */
    private void clearField() {
        ingredientName.setText("");
        ingredientsDescription.setText("");
        abvContent.setText("");
    }

    /**
     * updates an ingredients
     * @param i
     */
    public void update(int i){
        ingredientName.setText(ingredient.get(i).getName());
        ingredientsDescription.setText(ingredient.get(i).getDescription());
        abvContent.setText(Integer.toString(ingredient.get(i).getABV()));
    }
}