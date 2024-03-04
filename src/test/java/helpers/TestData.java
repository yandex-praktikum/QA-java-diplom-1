package helpers;

import com.github.javafaker.Faker;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;
import java.util.Random;

public class TestData {
    private final static Faker faker = new Faker();
    private final static Database database = new Database();
    private final static List<Bun> availableBuns = database.availableBuns();
    private final static List<Ingredient> availableIngredients = database.availableIngredients();

    public static Bun returnBunByIndex(int index) {
        try {
            return availableBuns.get(index);
        } catch (Exception exception) {
            throw new RuntimeException("No bun with given index was found");
        }
    }

    public static Bun returnRandomBun() {
        Random random = new Random();
        int index = random.nextInt(availableBuns.size());
        return availableBuns.get(index);
    }

    public static Ingredient returnIngredientByIndex(int index) {
        try {
            return availableIngredients.get(index);
        } catch (Exception exception) {
            throw new RuntimeException("No ingredient with given index was found");
        }
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
        if (secondIndex == index) {
            secondIndex = random.nextInt(ingredients.size());
        }
        return secondIndex;
    }

    public static String returnRandomBunName() {
        return faker.funnyName().name();
    }

    public static String returnRandomIngredientName() {
        return faker.twinPeaks().character();
    }

    public static float returnRandomPrice() {
        Random random = new Random();
        return random.nextFloat();
    }

    public static IngredientType returnRandomIngredientType() {
        Random random = new Random();
        IngredientType[] types = IngredientType.values();
        int index = random.nextInt(types.length);
        return types[index];
    }
}
