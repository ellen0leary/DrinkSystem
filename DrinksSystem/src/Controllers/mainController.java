package Controllers;

import Other.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import static Other.Main.drink;
import static Other.Main.ingredient;
import static Other.Main.recipe;

public class mainController {
    public Button viewAddDrinkPage,viewAddIngredientPage,viewAddRecipePage,viewViewAllPage,save,load,viewSearchPage;

    /**
     * keeps all the pages
     * @param actionEvent
     */
    public void Page(ActionEvent actionEvent) {
        viewAddDrinkPage.setOnAction(e -> Main.setAddDrink());
        viewAddIngredientPage.setOnAction((e -> Main.setAddIngredient()));
        viewAddRecipePage.setOnAction(e -> Main.setAddRecipe());
        viewViewAllPage.setOnAction(e -> Main.setViewAll());
        viewSearchPage.setOnAction(e -> Main.setSearch());

    }

    /**
     * delete all the infor
     * @param actionEvent
     */
    public void deleteAll(ActionEvent actionEvent) {
        ingredient.clear();
        drink.clear();
        recipe.clear();
    }

    /**
     * saves the info to an xml file
     * @param actionEvent
     */
    public void save(ActionEvent actionEvent) {
        try {
            Main.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * loads all the information from an xml file
     * @param actionEvent
     */
    public void load(ActionEvent actionEvent) {
        try {
            Main.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}