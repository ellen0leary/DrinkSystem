package Other;

import java.util.ArrayList;
import java.util.HashMap;

public class Recipes {
    private Drinks drink;
    private HashMap<Ingredients, Integer> ingredients;
    private int quantities;
    private String recipeSteps;

    /**
     * Constructor for recipes
     * @param drink details of drink used
     * @param ingredients list of ingredients
     * @param quantities amounts of quantities
     * @param recipeSteps Steps of the recipies
     */
    public Recipes(Drinks drink, HashMap<Ingredients, Integer> ingredients, int quantities, String recipeSteps) {
        this.drink = drink;
        this.ingredients = ingredients;
        this.quantities = quantities;
        this.recipeSteps = recipeSteps;
    }

    /**
     * get the drink involved in the recipies
     * @return the drink used
     */
    public Drinks getDrink() {
        return drink;
    }

    /**
     * set the drink used in the recipe
     * @param drink
     */
    public void setDrink(Drinks drink) {
        this.drink = drink;
    }

    /**
     * gets the ingredents
     * @return ingredents
     */
    public HashMap<Ingredients, Integer> getIngredients() {
        return ingredients;
    }

    /**
     * sets the ingredients for the recipes
     * @param ingredients ingredients used in recipes
     */
    public void setIngredients(HashMap<Ingredients, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * gets the quatities of ingredients
     * @return quantities of ingredients
     */
    public int getQuantities() {
        return quantities;
    }

    /**
     *| sets the quantities of ingredients used
     * @param quantities
     */
    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    /**
     * gets the recipes steps
     * @return recipe steps
     */
    public String getRecipeSteps() {
        return recipeSteps;
    }

    /**
     * sets the recipe steps
     * @param recipeSteps steps of the recipes
     */
    public void setRecipeSteps(String recipeSteps) {
        this.recipeSteps = recipeSteps;
    }

    /**
     * creates a string of recipes
     * @return to string of recipes
     */
    @Override
    public String toString() {
        return "Recipes " +
                "drink = " + drink +
                ", ingredients = " + ingredients.toString()  +
                ", quantities = " + quantities +
                ", recipeSteps = " + recipeSteps ;
    }
}