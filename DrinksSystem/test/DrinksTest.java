import Other.Drinks;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DrinksTest {

    Drinks d1,d2,d3,d4;
    @org.junit.Before
    public void setUp() throws Exception {
        d1 = new Drinks("Cola", "America", "It's cola", "https://www.coca-cola.ie/content/dam/journey/gb/en/hidden/Products/lead-brand-image/coca-cola-original-taste-gb-lead-598x336.rendition.320.179.jpg");
        d2 = new Drinks("Water", "literally everywhere","It's water","https://www.bbcgoodfood.com/sites/default/files/editor_files/2019/10/hydration-guide-main-image-700-350.jpg");
        d3 = new Drinks("Carlsberg","Denmark","A 3.8% danish pilsner","https://nutsaboutwine.ie/wp-content/uploads/2015/01/carlsberg-bottle1.jpg");
        d4 = new Drinks("Bulmers","Ireland","A 4% Irish Cider","https://nutsaboutwine.ie/wp-content/uploads/2015/01/bulmers-cider-can-468x468.jpg");
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getName() {
        assertEquals("Cola", d1.getName());
        assertEquals("Water", d2.getName());
        assertEquals("Carlsberg",d3.getName());
        assertEquals("Bulmers", d4.getName());
    }

    @org.junit.Test
    public void setName() {
        d1.setName("Coke");
        assertEquals("Coke", d1.getName());
        d2.setName("water");
        assertEquals("water", d2.getName());
        d3.setName("budweiser");
        assertEquals("budweiser",d3.getName());
        d4.setName("Orchard Thieves");
        assertEquals("Orchard Thieves", d4.getName());
    }

    @org.junit.Test
    public void getCountry() {
        assertEquals("America", d1.getCountry());
        assertEquals("literally everywhere", d2.getCountry());
        assertEquals("Denmark",d3.getCountry());
        assertEquals("Ireland", d4.getCountry());
    }

    @org.junit.Test
    public void setCountry() {
        d1.setCountry("'merica");
        assertEquals("'merica", d1.getCountry());
        d2.setCountry("look outside");
        assertEquals("look outside", d2.getCountry());
        d3.setCountry("Sweden");
        assertEquals("Sweden",d3.getCountry());
        d4.setCountry("America");
        assertEquals("America", d4.getCountry());
    }

    @org.junit.Test
    public void getDescription() {
        assertEquals("It's cola", d1.getDescription());
        assertEquals("It's water", d2.getDescription());
        assertEquals("A 3.8% danish pilsner",d3.getDescription());
        assertEquals("A 4% Irish Cider", d4.getDescription());
    }

    @org.junit.Test
    public void setDescription() {
        d1.setDescription("cola");
        assertEquals("cola", d1.getDescription());
        d2.setDescription("water");
        assertEquals("water", d2.getDescription());
        d3.setDescription("pilsner");
        assertEquals("pilsner",d3.getDescription());
        d4.setDescription("cider");
        assertEquals("cider", d4.getDescription());
    }

    @org.junit.Test
    public void getImageLink() {
        assertEquals("https://www.coca-cola.ie/content/dam/journey/gb/en/hidden/Products/lead-brand-image/coca-cola-original-taste-gb-lead-598x336.rendition.320.179.jpg", d1.getImageLink());
        assertEquals("https://www.bbcgoodfood.com/sites/default/files/editor_files/2019/10/hydration-guide-main-image-700-350.jpg", d2.getImageLink());
        assertEquals("https://nutsaboutwine.ie/wp-content/uploads/2015/01/carlsberg-bottle1.jpg",d3.getImageLink());
        assertEquals("https://nutsaboutwine.ie/wp-content/uploads/2015/01/bulmers-cider-can-468x468.jpg", d4.getImageLink());
    }

    @org.junit.Test
    public void setImageLink() {
        d1.setImageLink("something shorter");
        assertEquals("something shorter", d1.getImageLink());
        d2.setImageLink("these need to be shorter");
        assertEquals("these need to be shorter", d2.getImageLink());
        d3.setImageLink("anything shorter");
        assertEquals("anything shorter",d3.getImageLink());
        d4.setImageLink("short");
        assertEquals("short", d4.getImageLink());
    }

    @org.junit.Test
    public void toStringUsesAllFields() {
        assertThat(d1.toString().contains("Cola"), is(true));
        assertThat(d1.toString().contains("America"), is(true));
        assertThat(d1.toString().contains("It's cola"), is(true));
        assertThat(d1.toString().contains("https://www.coca-cola.ie/content/dam/journey/gb/en/hidden/Products/lead-brand-image/coca-cola-original-taste-gb-lead-598x336.rendition.320.179.jpg"),is(true));
    }
}