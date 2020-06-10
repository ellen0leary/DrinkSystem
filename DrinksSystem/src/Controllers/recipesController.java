package Controllers;

import Other.Drinks;
import Other.Ingredients;
import Other.Main;
import Other.Recipes;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import static Other.Main.*;

public class recipesController {

    public static recipesController recipeController;
    public Button RecipeSaveButton,cancel;
    public TextField amount, steps;
    public ChoiceBox drinksList, ingredientList;
    public String ingredientsAndAmount;
    public ListView ingredAndAmount;

    /**
     * loads the main menu page
     * @param actionEvent
     */
    public void cancel(ActionEvent actionEvent) {
        Main.setMainMenu();
    }

    /**
     * abd the options for both choice boxes
     */
    @SuppressWarnings("unchecked")
    public void addDrinkChoice(){
        drinksList.getItems().clear();
        ingredientList.getItems().clear();
        for(int i=0; i< drink.length();i++)
            drinksList.getItems().add(drink.get(i).toString());
        for(int i=0; i< Other.Main.ingredient.length();i++)
            ingredientList.getItems().add(Other.Main.ingredient.get(i).toString());
    }

    /**
     * andds the ingredient and amount
     */
    public void addIngredientAndAmount(){
        String ingredientInput= Other.Main.ingredient.get(ingredientList.getSelectionModel().getSelectedIndex()).getName() +"  "+ amount.getText() + "ml";
        ingredAndAmount.getItems().add(ingredientInput);
        ingredientsAndAmount += ingredientInput;
    }

    /**
     * saves the recipes
     * @param actionEvent
     */
    public void RecipeSaveButton(ActionEvent actionEvent) {
        Drinks drinkChoice = drink.get(drinksList.getSelectionModel().getSelectedIndex());
        //String ingredients = ingredientList.get;
        int quantities = Integer.parseInt(amount.getText());
        String recipeSteps = steps.getText();
        recipe.add(new Recipes(drinkChoice, ingredientsAndAmount, quantities, recipeSteps));
        Main.setMainMenu();
        clearField();
    }

    /**
     * load on start of page
     */
    public void startView() {
        addDrinkChoice();
    }

    /**
     * clears all the fields
     */
    @SuppressWarnings("unchecked")
    private void clearField() {
        drinksList.setValue(null);
        //ingredientList.setText("");
        amount.setText("");
        steps.setText("");
    }
    public void initialize(){
        recipeController = this;
    }
}
