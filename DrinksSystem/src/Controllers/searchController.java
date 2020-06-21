package Controllers;

import Other.Main;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static Other.Main.*;

public class searchController {
    public static searchController searchEverything;
    public Button search, cancel, sort;
    public TextField drinkName, ABV, descriptionKeyword;
    public ListView<String> searchResults;
    public ChoiceBox<String> sortBy;
    public ArrayList<String> results = new ArrayList<>();
    //public ChoiceBox drinksIngore, ingredientsIngore, repiceIngore;
    int[] array;

    /**
     * search through everything for details entered
     */
    public void searchButton() {
        searchResults.getItems().clear();
        String drinkSelection = drinkName.getText();
        String ABVSelection = ABV.getText().toLowerCase();
        String descriptionSelection = descriptionKeyword.getText().toLowerCase();
        for (int i = 0; i < drink.length(); i++) {
            if ((drink.get(i).getName().toLowerCase().contains(drinkSelection.toLowerCase())) ||
                    (drink.get(i).toString().contains(ABVSelection)) ||
                    (drink.get(i).getName().toLowerCase().contains(descriptionSelection))) {
                searchResults.getItems().add(drink.get(i).toString());
                results.add(drink.get(i).toString());
            }
        }
        for (int i = 0; i < ingredient.length(); i++) {
            if ((ingredient.get(i).toString().toLowerCase().contains(drinkSelection)) ||
                    (ingredient.get(i).toString().toLowerCase().contains(ABVSelection)) ||
                    (ingredient.get(i).toString().toLowerCase().contains(descriptionSelection))) {
                searchResults.getItems().add(ingredient.get(i).toString());
                results.add(ingredient.get(i).toString());
            }
        }
        for (int i = 0; i < recipe.length(); i++) {
            if ((recipe.get(i).toString().toLowerCase().contains(drinkSelection)) ||
                    (recipe.get(i).toString().toLowerCase().contains(ABVSelection)) ||
                    (recipe.get(i).getRecipeSteps().toLowerCase().contains(descriptionSelection))) {
                searchResults.getItems().add(recipe.get(i).toString());
                results.add(recipe.get(i).toString());
            }
        }
    }

    /**
     * tries to sort out everything but it don't work
     */
    public void sort() {
        if (sortBy.getSelectionModel().getSelectedItem().equals("Sort by A->Z")) {
            sortByAToZ();
        } else if (sortBy.getSelectionModel().getSelectedItem().equals("Sort by Z-A")) {
            sortByZToA();
        } else {
            for (int i = 0; i <= searchResults.getItems().size(); i++)
                if (searchResults.getItems().contains("Drink")) {
                }
        }
    }

    private void sortByAToZ() {
        array = new int[searchResults.getItems().size()];
        System.out.println(searchResults.getItems().size());
        for (int i = 0; i < searchResults.getItems().size(); i++) {
            array[i] = hash(results.get(i));
        }
        insertionSort(array);
        searchResults.getItems().clear();
        for (int value : array) {
            for (String result : results) {
                if (value == hash(result)) {
                    searchResults.getItems().add(result);
                }
            }
        }
    }

    private void sortByZToA() {
        array = new int[searchResults.getItems().size()];
        System.out.println(searchResults.getItems().size());
        for (int i = 0; i < searchResults.getItems().size(); i++) {
            array[i] = hash(results.get(i));
        }
        insertionSort(array);
        searchResults.getItems().clear();
        for (int i = array.length - 1; i > 0; i--) {
            for (String result : results) {
                if (array[i] == hash(result)) {
                    searchResults.getItems().add(result);
                }
            }
        }
    }

    /**
     * an attempt an insertion sort
     *
     * @param a
     */
    public void insertionSort(int[] a) {
        for (int e = 1; e < a.length; e++) {
            int element = a[e], i;
            for (i = e; i >= 1 && a[i - 1] > element; i--)
                a[i] = a[i - 1];
            a[i] = element;
        }
    }

    /**
     * hashes a string based on the first char in the drink name
     *
     * @param str
     * @return
     */
    public int hash(String str) {
        int hash = 7;
        for (int i = 0; i < str.length(); i++) {
            hash = 13 * hash + str.charAt(i);
        }
        return hash;
    }

    /**
     * returns back to main menu
     *
     * @param actionEvent
     */
    public void Cancel(javafx.event.ActionEvent actionEvent) {
        Main.setMainMenu();
    }

    /**
     * loads on start of page
     * add the items to choice box
     */
    public void startView() {
        sortBy.getItems().clear();
        sortBy.getItems().addAll("Sort by A->Z", "Sort by Z->A", "Sort by ABV %");
    }

    public void initialize() {
        searchEverything = this;
    }
}
