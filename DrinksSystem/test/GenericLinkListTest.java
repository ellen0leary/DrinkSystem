import Other.Drinks;
import Other.GenericLinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class GenericLinkListTest {

    Drinks d1,d2,d3;
    GenericLinkedList g;
    @Before
    public void setUp() throws Exception {
        d1 = new Drinks("Cola", "America", "It's cola");
        d2 = new Drinks("Water", "literally everywhere","It's water");
        d3 = new Drinks("Carlsberg","Denmark","A 3.8% danish pilsner");

        g = new GenericLinkedList();
        g.add(d1);
        g.add(d2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        assertEquals(2,g.length());
        g.add(d3);
        assertEquals(3,g.length());
    }

    @Test
    public void clear() {
        assertEquals(2,g.length());
        g.clear();
        assertEquals(0,g.length());
    }

    @Test
    public void deleteByIndex() {
        assertEquals(2, g.length());
        g.deleteByIndex(0);
        assertEquals(1,g.length());
    }

    @Test
    public void length() {
        assertEquals(2,g.length());
        g.add(d3);
        assertEquals(3,g.length());
    }

    @Test
    public void get() {
        assertThat(g.get(1),is(instanceOf(Drinks.class)));
    }
}