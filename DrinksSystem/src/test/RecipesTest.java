package test;

import Other.Drinks;
import Other.Ingredients;
import Other.Recipes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RecipesTest {
    Recipes r1,r2;
    Drinks d1,d2;

    @Before
    public void setUp() throws Exception {
        d1 = new Drinks("Vodka","Russia","Its vodka","a link");
        d2= new Drinks("Rum","Somewhere","Its rum","another link");

        r1 = new Recipes(d1,"Lemon",30,"Mix vodka and lemon");
        r2 = new Recipes(d1,"Cola",200,"Mix Vodka and Cola");

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
    public void getIngredents() {
        assertEquals("Lemon", r1.getIngredients());
        assertEquals("Cola",r2.getIngredients());
    }

    @Test
    public void setIngredents() {
        r1.setIngredients("Lime");
        assertEquals("Lime", r1.getIngredients());
        r2.setIngredients("Lemonade");
        assertEquals("Lemonade",r2.getIngredients());
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