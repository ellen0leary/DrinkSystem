package Other;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import static Controllers.drinksController.drinkController;
import static Controllers.ingredientsController.ingredientController;
import static Controllers.recipesController.recipeController;
import static Controllers.searchController.searchEverything;
import static Controllers.viewAllController.viewEverythingController;

/*
to do:
    fix sort
 */
public class Main extends Application {
    private static Scene start,addIngredient, addDrink, addRecipe, viewAll,viewSearch;
    private static Stage stage;
    public static GenericLinkedList<Drinks> drink= new GenericLinkedList<>();
    public static GenericLinkedList<Ingredients> ingredient= new GenericLinkedList<>();
    public static GenericLinkedList<Recipes> recipe= new GenericLinkedList<>();


    /**
     * start function of the program
     * @param primaryStage uses as the stage for scene builder
     * @throws Exception of it can't find scenes
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FXML/start.fxml"));
            Parent addDrinks = FXMLLoader.load(getClass().getResource("../FXML/addDrink.fxml"));
            Parent addIngredients = FXMLLoader.load(getClass().getResource("../FXML/addIngredients.fxml"));
            Parent addRecipes = FXMLLoader.load(getClass().getResource("../FXML/addRecipes.fxml"));
            Parent viewAllStuff = FXMLLoader.load(getClass().getResource("../FXML/viewAll.fxml"));
            Parent viewSearchEverything = FXMLLoader.load(getClass().getResource("../FXML/search.fxml"));


            stage = primaryStage;
            primaryStage.setTitle("Main Menu");
            start = new Scene(root, 600, 500);
            addDrink = new Scene(addDrinks, 600, 500);
            addIngredient = new Scene(addIngredients, 600, 500);
            addRecipe = new Scene(addRecipes, 600, 500);
            viewAll = new Scene(viewAllStuff, 600, 500);
            viewSearch = new Scene(viewSearchEverything, 600,500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        primaryStage.setScene(start);
        primaryStage.show();
    }

    /**
     * sets the scene for adding a drink
     */
    public static void setAddDrink() {
        stage.setScene(addDrink);
    }

    /**
     * sets the scene for update drink
     * @param i the index of the drink needed to be updated
     */
    public static void setUpdateDrink(int i) {
        stage.setScene(addDrink);
        drinkController.update(i);
    }

    /**
     * sets the scene of the add ingredient
     */
    public static void setAddIngredient() {
        stage.setScene(addIngredient);
    }

    /**
     * sets the scene for updating ingredients
     * @param i index of the ingredient needing updating
     */
    public static void setUpdateIngredient(int i){
        stage.setScene(addIngredient);
        ingredientController.update(i);
    }

    /**
     * sets the scene for the add recipe
     */
    public static void setAddRecipe() {
        recipeController.startView();
        stage.setScene(addRecipe);
    }

    /**
     * sets the scene for view all
     */
    public static void setViewAll() {
        viewEverythingController.startView();
        stage.setScene(viewAll);
    }

    /**
     * set the scene for main menu
     */
    public static void setMainMenu() {
        stage.setScene(start);
    }

    /**
     * set the scene for search
     */
    public static void setSearch() {
        searchEverything.startView();
        stage.setScene(viewSearch);
    }

    /**
     * loads from an xml file
     * @throws Exception if error is found
     */
    @SuppressWarnings("unchecked")
    public static void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("drinks.xml"));
        ingredient = (GenericLinkedList<Ingredients>) is.readObject();
        drink = (GenericLinkedList<Drinks>) is.readObject();
        recipe = (GenericLinkedList<Recipes>) is.readObject();
        is.close();
    }

    /**
     * saves to an xml file
     * @throws Exception if error is found
     *
     * */
    public static void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("drinks.xml"));
        out.writeObject(ingredient);
        out.writeObject(drink);
        out.writeObject(recipe);
        out.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}