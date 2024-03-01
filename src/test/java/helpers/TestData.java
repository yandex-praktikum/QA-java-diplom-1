package helpers;

import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;
import java.util.Random;

public class TestData {
    private final static Database database = new Database();
    private final static List<Bun> availableBuns = database.availableBuns();
    private final static List<Ingredient> availableIngredients = database.availableIngredients();

    public static Bun returnFirstBun() {
        return availableBuns.get(0);
    }

    public static Bun returnSecondBun() {
        return availableBuns.get(1);
    }

    public static Bun returnThirdBun() {
        return availableBuns.get(2);
    }

    public static Bun returnBunByIndex(int index){
            return availableBuns.get(index);
    }

    public static Bun returnRandomBun() {
        Random random = new Random();
        int index = random.nextInt(availableBuns.size());
        return availableBuns.get(index);
    }

    public static Ingredient returnFirstIngredient() {
        return availableIngredients.get(0);
    }

    public static Ingredient returnSecondIngredient() {
        return availableIngredients.get(1);
    }

    public static Ingredient returnThirdIngredient() {
        return availableIngredients.get(2);
    }

    public static Ingredient returnFourthIngredient() {
        return availableIngredients.get(3);
    }

    public static Ingredient returnFifthIngredient() {
        return availableIngredients.get(4);
    }

    public static Ingredient returnSixthIngredient() {
        return availableIngredients.get(5);
    }

    public static Ingredient returnIngredientByIndex(int index) {
        return availableIngredients.get(index);
    }

    public static Ingredient returnRandomIngredient() {
        Random random = new Random();
        int index = random.nextInt(availableIngredients.size());
        return availableIngredients.get(index);
    }

    public static int generateIndex(List<Ingredient> ingredients) {
        Random random = new Random();
        return random.nextInt(ingredients.size());
    }

    public static int generateIndex(int index, List<Ingredient> ingredients) {
        Random random = new Random();
        int secondIndex = random.nextInt(ingredients.size());
        if(secondIndex==index) {
            secondIndex = random.nextInt(ingredients.size());
        }
        return secondIndex;
    }
}
