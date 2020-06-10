package test;

import Other.Ingredients;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class IngredientsTest {

    Ingredients i1,i2,i3,i4;

    @Before
    public void setUp() throws Exception {
        i1 = new Ingredients("Lemon","Its a lemon",0);
        i2 = new Ingredients("Lime","Its a green lemon",0);
        i3 = new Ingredients("Tonic water","Taste like shit",0);
        i4 = new Ingredients("Orange Liqueur","It is a neutral grain spirit with an orange flavour",40);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() {
        assertEquals("Lemon",i1.getName());
        assertEquals("Lime", i2.getName());
        assertEquals("Tonic water", i3.getName());
        assertEquals("Orange Liqueur", i4.getName());
    }

    @Test
    public void getDescription() {
        assertEquals("Its a lemon",i1.getDescription());
        assertEquals("Its a green lemon", i2.getDescription());
        assertEquals("Taste like shit", i3.getDescription());
        assertEquals("It is a neutral grain spirit with an orange flavour", i4.getDescription());
    }

    @Test
    public void getABV() {
        assertEquals(0,i1.getABV());
        assertEquals(0, i2.getABV());
        assertEquals(0, i3.getABV());
        assertEquals(40, i4.getABV());
    }

    @Test
    public void setName() {
        i1.setName("Lime");
        assertEquals("Lime",i1.getName());
        i2.setName("Lemon");
        assertEquals("Lemon", i2.getName());
        i3.setName("Water");
        assertEquals("Water", i3.getName());
        i4.setName("Strawberry Liqueur");
        assertEquals("Strawberry Liqueur", i4.getName());
    }

    @Test
    public void setDescription() {
        i1.setDescription("Its bitter");
        assertEquals("Its bitter",i1.getDescription());
        i2.setDescription("Its very green");
        assertEquals("Its very green", i2.getDescription());
        i3.setDescription("Actually shit");
        assertEquals("Actually shit", i3.getDescription());
        i4.setDescription("Its orange vodka");
        assertEquals("Its orange vodka", i4.getDescription());
    }

    @Test
    public void setABV() {
        i1.setABV(5);
        assertEquals(5,i1.getABV());
        i2.setABV(25);
        assertEquals(25, i2.getABV());
        i3.setABV(50);
        assertEquals(50, i3.getABV());
        i4.setABV(100);
        assertEquals(100, i4.getABV());
    }

    @Test
    public void toStringUsingAllFields() {
        assertThat(i1.toString().contains("Lemon"), is(true));
        assertThat(i1.toString().contains("Its a lemon"), is(true));
        assertThat(i1.toString().contains("0"), is(true));
    }
}