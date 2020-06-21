package Other;

public class Drinks {
    private String name;
    private String country;
    private String description;
    private int ABV;

    /**
     *  main constructor of drink
     * @param name
     * @param country
     * @param description
     */
    public Drinks(String name, String country, String description) {
        this.name = name;
        this.country = country;
        this.description = description;
    }

    /**
     * gets the name of the drink
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the drink
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the name of the country
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     * sets the name of the country
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * get the description of the drink
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *  sets the description of the drink
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }



    /**
     * creates a to string for drinks
     * @return to string
     */
    @Override
    public String toString() {
        return "Drinks " +
                "name = " + name  +
                ", country = " + country  +
                ", description = " + description ;
    }
}