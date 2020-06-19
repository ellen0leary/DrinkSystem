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
    int[] array;

    /**
     * search through everything for details entered
     */
    public void searchButton() {
        searchResults.getItems().clear();
        String drinkSelection = drinkName.getText().toLowerCase();
        String ABVSelection = ABV.getText().toLowerCase();
        String descriptionSelection = descriptionKeyword.getText().toLowerCase();
        int i = 0;
        for (; i <= drink.length(); i++)
            if ((drink.get(i).getName().toLowerCase().contains(drinkSelection)) ||
                    (drink.get(i).toString().toLowerCase().contains(ABVSelection)) ||
                    (drink.get(i).getName().toLowerCase().contains(descriptionSelection))) {
                searchResults.getItems().add(drink.get(i).toString());
                results.add(drink.get(i).getName());
            }
        for (; i <= ingredient.length(); i++)
            if ((ingredient.get(i).getName().toLowerCase().contains(drinkSelection)) ||
                    (ingredient.get(i).toString().toLowerCase().contains(ABVSelection)) ||
                    (ingredient.get(i).getName().toLowerCase().contains(descriptionSelection))) {
                searchResults.getItems().add(ingredient.get(i).toString());
                results.add(ingredient.get(i).getName());
            }
        for (; i <= recipe.length(); i++)
            if ((recipe.get(i).toString().toLowerCase().contains(drinkSelection)) ||
                    (recipe.get(i).toString().toLowerCase().contains(ABVSelection)) ||
                    (ingredient.get(i).getName().toLowerCase().contains(descriptionSelection))) {
                searchResults.getItems().add(recipe.get(i).toString());
                results.add(recipe.get(i).getDrink().getName());
            }
    }

    /**
     * tries to sort out everything but it don't work
     */
    public void sort() {
        //ListView<String> sortedResults = new ListView<>();
        if (sortBy.getSelectionModel().getSelectedItem().equals("Sort by A->Z")) {
            array = new int[searchResults.getItems().size()];
            System.out.println(searchResults.getItems().size());
            for (int i = 0; i <searchResults.getItems().size(); i++) {
                System.out.println(hash(results.get(i)));
                array[i] = hash(results.get(i));
            }
            System.out.println("Before sort: ");
            for(int i=0; i<array.length; i++) {
                System.out.println(i+ " :" +array[i]);
            }
            insertionSort(array);
            System.out.println("After sort");
            for(int i=0; i<array.length; i++) {
                System.out.println(i+ " :" +array[i]);
            }
            searchResults.getItems().clear();
            for (int i = 0; i < array.length; i++) {
                for(int x=0; i<results.size(); i++) {
                    if (array[i] ==hash(results.get(x)))
                        searchResults.getItems().add(results.get(x));
                    else
                        searchResults.getItems().add(array[i] + ":  "+ hash(results.get(x)));
                }
            }
        } else {
            for (int i = 0; i <= searchResults.getItems().size(); i++)
                if (searchResults.getItems().contains("Drink")) {
                }
            //sortedResults = searchResults;
        }
    }

    /**
     * an attempt an insertion sort
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
     * src: https://www.javatpoint.com/selection-sort-in-java
     *
     * @param arr
     */
    public int[] selectionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int spare = i;
            for (int e = i; e < arr.length; e++) {
                if (arr[e] < arr[spare])
                    spare = e;
            }
            int smallestNum = arr[spare];
            arr[spare] = arr[i];
            arr[i] = smallestNum;
        }
        return arr;
    }

    /**
     * hashes a string based on the first char in the drink name
     *
     * @param str
     * @return
     */
    public int hash(String str) {
        int hash = 7;
        for(int i=0; i<str.length(); i++){
            hash = 13*hash + str.charAt(i);
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
        sortBy.getItems().addAll("Sort by A->Z", "Sort by ABV %");
    }

    public void initialize() {
        searchEverything = this;
    }
}
