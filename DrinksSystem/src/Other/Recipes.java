package Other;

import java.util.ArrayList;
import java.util.HashMap;

public class Recipes {
    private String name;
    private HashMap<Drinks, Integer> drink;
    private HashMap<Ingredients, Integer> ingredients;
    private String recipeSteps;

    /**
     * Constructor for recipes
     * @param drink details of drink used
     * @param ingredients list of ingredients
     * @param recipeSteps Steps of the recipies
     */
    public Recipes(String name,HashMap<Drinks, Integer> drink, HashMap<Ingredients, Integer> ingredients, String recipeSteps) {
        this.name =name;
        this.drink = drink;
        this.ingredients = ingredients;
        this.recipeSteps = recipeSteps;
    }


    public HashMap<Drinks, Integer> getDrink() {return drink;}

    public void setDrink(HashMap<Drinks, Integer> drink) {this.drink = drink; }
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
                ", drinks = " + drink.toString() +
                ", recipeSteps = " + recipeSteps ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}