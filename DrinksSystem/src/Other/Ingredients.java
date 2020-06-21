package Other;

public class Ingredients {
    private String name;
    private String description;
    private int ABV;

    /**
     * main constructor for ingredients
     *
     * @param name        name of ingredient
     * @param description description of ingredient
     * @param ABV         abv of ingredient
     */
    public Ingredients(String name, String description, int ABV) {
        this.name = name;
        this.description = description;
        this.ABV = ABV;
    }

    /**
     * get the name of ingredient
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * gets the description of ingredients
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * gets the adv of ingredients
     *
     * @return
     */
    public int getABV() {
        return ABV;
    }

    /**
     * sets the name of ingredient
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets the description of ingredient
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * sets the abv of the ingredient
     *
     * @param ABV
     */
    public void setABV(int ABV) {
        this.ABV = ABV;
    }

    /**
     * creates a string of ingredients
     *
     * @return string of ingredients
     */
    @Override
    public String toString() {
        return "Ingredients" +
                "name = " + name +
                ", ABV = " + ABV +
                ", description = " + description;
    }

}