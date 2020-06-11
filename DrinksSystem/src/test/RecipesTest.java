package test;

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

    @Before
    public void setUp() throws Exception {
        d1 = new Drinks("Vodka","Russia","Its vodka","a link");
        d2= new Drinks("Rum","Somewhere","Its rum","another link");

        i1 = new Ingredients("Lemon","Its a lemon",0);
        i2 = new Ingredients("Lime","Its a green lemon",0);

        ingredients.put(i1, 40);
        ingredients.put(i2, 60);
        r1 = new Recipes(d1,ingredients,30,"Mix vodka and lemon");
        r2 = new Recipes(d1,ingredients,200,"Mix Vodka and Cola");

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDrink() {
        assertEquals(d1, r1.getDrink());
        assertEquals(d1,r2.getDrink());
    }

    @Test
    public void setDrink() {
        r1.setDrink(d2);
        assertEquals(d2, r1.getDrink());
        r2.setDrink(d2);
        assertEquals(d2,r2.getDrink());
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
    public void getQuantites() {
        assertEquals(30,r1.getQuantities());
        assertEquals(200,r2.getQuantities());
    }

    @Test
    public void setQuantites() {
        r1.setQuantities(50);
        assertEquals(50,r1.getQuantities());
        r2.setQuantities(500);
        assertEquals(500,r2.getQuantities());
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
        assertThat(r1.toString().contains("30"), is(true));
        assertThat(r1.toString().contains("Mix vodka and lemon"), is(true));
    }
}