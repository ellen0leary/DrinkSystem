package Other;

import java.util.HashMap;

import static Other.Main.ingredient;

public class Recipes {
    private String name;
    private HashMap<Drinks, Integer> drinks;
    private HashMap<Ingredients, Integer> ingredients;
    private String recipeSteps;
    private int abv;

    /**
     * Constructor for recipes
     * @param drinks details of drink used
     * @param ingredients list of ingredients
     * @param recipeSteps Steps of the recipies
     */
    public Recipes(String name,HashMap<Drinks, Integer> drinks, HashMap<Ingredients, Integer> ingredients, String recipeSteps) {
        this.name =name;
        this.drinks = drinks;
        this.ingredients = ingredients;
        this.recipeSteps = recipeSteps;
        for(int i=0; i<ingredient.length(); i++){
            if(ingredients.containsKey(ingredient.get(i))){
                abv+= ingredient.get(i).getABV();
            }
        }
    }


    public HashMap<Drinks, Integer> getDrink() {return drinks;}

    public void setDrink(HashMap<Drinks, Integer> drink) {this.drinks = drink; }
    /**
     * gets the ingredients
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
                "Recipe name = " + name +
                ", ingredients = " + ingredients.toString()  +
                ", drinks = " + drinks.toString() +
                ", recipeSteps = " + recipeSteps ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAbv() {return abv;}
    public void setAbv(int abv) { this.abv = abv;}
}