package Controllers;

import Other.Drinks;
import Other.Ingredients;
import Other.Main;
import Other.Recipes;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class viewAllController {
    public static viewAllController viewEverythingController;
    private ListView<String> DrinkListViews, IngredientListViews, RecipeListViews;
    public TextField deleteADrink, deleteAIngredient, deleteARecipe;
    public Button mainPageButton, confirmDelete, update;
    public ListView drinkListView, ingredientListView, recipeListView;

    /**
     *  loads on page start
     *  Fills all listviews
     */
    public void startView() {
        IngredientListViews.getItems().clear();
        RecipeListViews.getItems().clear();
        DrinkListViews.getItems().clear();
        if(Main.ingredient.length()>0){
            for(int i=0; i< Main.ingredient.length();i++)
                IngredientListViews.getItems().add(Main.ingredient.get(i).toString());
        } else
            IngredientListViews.getItems().add("No Ingredient available");
        if(Main.recipe.length()>0){
            for(int i=0; i< Main.recipe.length();i++)
                RecipeListViews.getItems().add(Main.recipe.get(i).toString());
        } else
            RecipeListViews.getItems().add("No Recipe available");
        if(Main.drink.length()>0){
            for(int i=0; i< Main.drink.length();i++)
                DrinkListViews.getItems().add(Main.drink.get(i).toString());
        } else
            DrinkListViews.getItems().add("No Drinks available");

    }

    /**
     * loads the main menu
     * @param actionEvent
     */
    public void mainPageButton(ActionEvent actionEvent) {
        Main.setMainMenu();
    }

    /**
     * deletes the entered index if  its correct
     */
    public void delete() {
        if (deleteADrink.getText().equals("")) {
            System.out.print("no drink to delete");
        } else {
            int i = Integer.parseInt(deleteADrink.getText());
            Main.drink.deleteByIndex(i);
            DrinkListViews.getItems().remove(i);
        }
        if (deleteAIngredient.getText().equals("")) {
            System.out.print("no ingredient to delete");
        } else {
            int i2 = Integer.parseInt(deleteAIngredient.getText());
            Main.ingredient.deleteByIndex(i2);
            IngredientListViews.getItems().remove(i2);
        }
        if (deleteARecipe.getText().equals("")) {
            System.out.print("No recipes to delete");
        } else {
            int i3 = Integer.parseInt(deleteARecipe.getText());
            Main.recipe.deleteByIndex(i3);
            RecipeListViews.getItems().remove(i3);
        }

    }

    /**
     * confirm the delete
     * @param actionEvent
     */
    public void confirmDelete(ActionEvent actionEvent) {
        delete();
        deleteADrink.setText(" ");
        deleteAIngredient.setText(" ");
        deleteARecipe.setText(" ");
    }

    @SuppressWarnings("unchecked")
    public void initialize() {
        DrinkListViews = drinkListView;
        IngredientListViews = ingredientListView;
        RecipeListViews = recipeListView;
        viewEverythingController = this;
    }

    /**
     * updates the chosen elements
     */
    public void update(){
        int i;
        if (drinkListView.getItems().get(0).equals("No Drinks available")) {
            System.out.print("no drink to update");
        } else {
            i =drinkListView.getSelectionModel().getSelectedIndex();
            Main.drink.deleteByIndex(i);
            Main.setUpdateDrink(i);
            DrinkListViews.getItems().remove(i);
        }
        if (ingredientListView.getItems().get(0).equals("No Ingredient available")) {
            System.out.print("no ingredient to update");
        } else {
            i = ingredientListView.getSelectionModel().getSelectedIndex();
            Main.ingredient.deleteByIndex(i);
            Main.setUpdateIngredient(i);
            IngredientListViews.getItems().remove(i);
        }
    }

}