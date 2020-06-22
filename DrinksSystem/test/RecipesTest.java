import Other.Drinks;
import Other.Ingredients;
import Other.Recipes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RecipesTest {
    Recipes r1,r2;
    Ingredients i1, i2;
    Drinks d1,d2;
    HashMap<Ingredients, Integer> ingredients = new HashMap<>();
    HashMap<Drinks, Integer> drinks = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        d1 = new Drinks("Vodka","Russia","Its vodka");
        d2= new Drinks("Rum","Somewhere","Its rum");

        i1 = new Ingredients("Lemon","Its a lemon",0);
        i2 = new Ingredients("Lime","Its a green lemon",0);

        ingredients.put(i1, 40);
        drinks.put(d1, 25);
        r1 = new Recipes("Vodka and lemon",drinks,ingredients,"Mix vodka and lemon");
        r2 = new Recipes("Vodka and coke",drinks,ingredients,"Mix Vodka and Cola");

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName(){
        assertEquals("Vodka and lemon", r1.getName());
        assertEquals("Vodka and coke", r2.getName());
    }

    @Test
    public void setName(){
        r1.setName("Vodka and coke");
        assertEquals("Vodka and coke", r1.getName());
        r2.setName("Rum and Coke");
        assertEquals("Rum and Coke", r2.getName());
    }
    @Test
    public void getDrink() {
        assertEquals(drinks, r1.getDrink());
        assertEquals(drinks,r2.getDrink());
    }

    @Test
    public void setDrink() {
        drinks.clear();
        drinks.put(d2, 25);
        r1.setDrink(drinks);
        assertEquals(drinks, r1.getDrink());
        drinks.put(d1, 50);
        r2.setDrink(drinks);
        assertEquals(drinks,r2.getDrink());
    }

    @Test
    public void getIngredients() {
        assertEquals(ingredients, r1.getIngredients());
        assertEquals(ingredients,r2.getIngredients());
    }

    @Test
    public void setIngredents() {
        ingredients.clear();
        ingredients.put(i2, 15);
        r1.setIngredients(ingredients);
        assertEquals(ingredients, r1.getIngredients());
        ingredients.clear();
        ingredients.put(i1,10);
        r2.setIngredients(ingredients);
        assertEquals(ingredients,r2.getIngredients());
    }

    @Test
    public void getRecipieSteps() {
        assertEquals("Mix vodka and lemon",r1.getRecipeSteps());
        assertEquals("Mix Vodka and Cola",r2.getRecipeSteps());
    }

    @Test
    public void setRecipieSteps() {
        r1.setRecipeSteps("Mix lemon and vodka");
        assertEquals("Mix lemon and vodka",r1.getRecipeSteps());
        r2.setRecipeSteps("Mix cola and vodka");
        assertEquals("Mix cola and vodka",r2.getRecipeSteps());

    }

    @Test
    public void toStringUsingAllFields() {
        assertThat(r1.toString().contains("Vodka"), is(true));
        assertThat(r1.toString().contains("Lemon"), is(true));
        assertThat(r1.toString().contains("Mix vodka and lemon"), is(true));
    }
}