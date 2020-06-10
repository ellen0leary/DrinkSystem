package Controllers;

import Other.Main;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import static Other.Main.*;

public class searchController {
    public static searchController searchEverything;
    public Button search,cancel, sort;
    public TextField drinkName, ABV, descriptionKeyword;
    public ListView searchResults;
    public ChoiceBox sortBy;

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
            if ((drink.get(i).getName().toLowerCase().contains(drinkSelection)) || (drink.get(i).toString().toLowerCase().contains(ABVSelection)) || (drink.get(i).getName().toLowerCase().contains(descriptionSelection)))
                searchResults.getItems().add(drink.get(i).toString());
        for(; i <= ingredient.length(); i++)
            if ((ingredient.get(i).getName().toLowerCase().contains(drinkSelection)) || (ingredient.get(i).toString().toLowerCase().contains(ABVSelection)) || (ingredient.get(i).getName().toLowerCase().contains(descriptionSelection)))
                searchResults.getItems().add(ingredient.get(i).toString());
        for (; i <= recipe.length(); i++)
            if ((recipe.get(i).toString().toLowerCase().contains(drinkSelection)) || (recipe.get(i).toString().toLowerCase().contains(ABVSelection)) || (ingredient.get(i).getName().toLowerCase().contains(descriptionSelection)))
                searchResults.getItems().add(recipe.get(i).toString());
    }

    /**
     * tries to sort out everything but it don't work
     */
    public void sort(){
        ListView sortedResults = new ListView();
        if (sortBy.getSelectionModel().getSelectedItem().toString().equals("Sort by A->Z")) {
            int[] array = null;
            for (int i = 0; i <= searchResults.getItems().size(); i++) {
                array[i] = hash(searchResults.getItems().get(i).toString());
            }
            selectionSort(array);
        } else {
            for(int i=0; i<=searchResults.getItems().size();i++)
                if(searchResults.getItems().contains("Drink"))
                    sortedResults = searchResults;
        }
    }

    /**
     * an attempt an insertion sort
     * @param a

    public void insertionSort(int[] a){
        for(int e=1; e< a.length;e++) {
            int element = a[e], i ;
            for(i= e; i>=1 && a[i-1]>element; i--)
                a[i] = a[i-1];
            a[i] = element;
        }
    }*/

    /**
     * src: https://www.javatpoint.com/selection-sort-in-java
     * @param str
     */
    public void selectionSort(int[] str){
        for (int i=1; i<str.length; i++){
            int spare = i;
            for (int e=i; e<str.length;e++){
                if (str[e]<str[spare])
                    spare=e;
            }
            int smallestNum = str[spare];
            str[spare] = str[i];
            str[i] = smallestNum;
        }
    }

    /**
     * hashes a string based on the first char in the drink name
     * @param str
     * @return
     */
    public int hash(String str){
        return str.charAt(16);
    }

    /**
     * returns back to main menu
     * @param actionEvent
     */
    public void Cancel(javafx.event.ActionEvent actionEvent) {
        Main.setMainMenu();
    }

    /**
     * loads on start of page
     * add the items to choice box
     */
    public void startView(){
        sortBy.getItems().clear();
        sortBy.getItems().addAll("Sort by A->Z", "Sort by ABV %");
    }

    public void initialize(){
        searchEverything = this;
    }
}
