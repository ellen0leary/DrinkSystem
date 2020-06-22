package Controllers;

import Other.Drinks;
import Other.Ingredients;
import Other.Main;
import Other.Recipes;
import javafx.scene.control.*;

import java.util.HashMap;

import static Other.Main.*;

public class recipesController {

    public static recipesController recipeController;
    public Button RecipeSaveButton,cancel;
    public TextField amount, drinkQuant,nameEntered;
    public TextArea steps;
    public ChoiceBox<String> drinksList;
    public ChoiceBox<String> ingredientList;
    public HashMap<Ingredients, Integer> ingredientsAndAmount = new HashMap<>();
    public HashMap<Drinks, Integer> drinksMap = new HashMap<>();
    public ListView<String> ingredAndAmount;

    /**
     * loads the main menu page
     */
    public void cancel() {
        Main.setMainMenu();
    }

    /**
     * abd the options for both choice boxes
     */
    public void addDrinkChoice(){
        drinksList.getItems().clear();
        ingredientList.getItems().clear();
        for(int i=0; i< drink.length();i++)
            drinksList.getItems().add(drink.get(i).getName());
        for(int i=0; i< Other.Main.ingredient.length();i++)
            ingredientList.getItems().add(Other.Main.ingredient.get(i).getName());
    }

    /**
     * ands the ingredient and amount
     */
    public void addIngredientAndAmount(){
        Ingredients chosenIngredient = Main.ingredient.get(ingredientList.getSelectionModel().getSelectedIndex());
        ingredientsAndAmount.put(chosenIngredient, Integer.parseInt(amount.getText()));
        ingredAndAmount.getItems().add(chosenIngredient.getName() +" "+amount.getText()+" ml");
        amount.setText("");
        ingredientList.getSelectionModel().clearSelection();
    }

    public void addDrinkandQuant(){
        Drinks chosenDrink = drink.get(drinksList.getSelectionModel().getSelectedIndex());
        drinksMap.put(chosenDrink, Integer.parseInt(drinkQuant.getText()));
        ingredAndAmount.getItems().add(chosenDrink.getName()+ " "+drinkQuant.getText()+ " ml");
        drinkQuant.setText("");
        drinksList.getSelectionModel().clearSelection();
    }
    /**
     * saves the recipes
     */
    public void RecipeSaveButton() {
        String drinkName = nameEntered.getText();
        String recipeSteps = steps.getText();
        recipe.add(new Recipes(drinkName, drinksMap, ingredientsAndAmount, recipeSteps));
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
    private void clearField() {
        nameEntered.setText("");
        drinksList.setValue(null);
        amount.setText("");
        steps.setText("");
        drinkQuant.setText("");
    }
    public void initialize(){
        recipeController = this;
    }
}
