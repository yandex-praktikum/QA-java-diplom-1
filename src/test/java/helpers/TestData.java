package helpers;

import com.github.javafaker.Faker;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;
import java.util.Random;

public class TestData {
    private final static Faker FAKER = new Faker();
    private final static Database DATABASE = new Database();
    private final static List<Bun> AVAILABLE_BUNS = DATABASE.availableBuns();
    private final static List<Ingredient> AVAILABLE_INGREDIENTS = DATABASE.availableIngredients();
    public static final float DELTA = 0.0f;

    public static Bun returnBunByIndex(int index) {
        try {
            return AVAILABLE_BUNS.get(index);
        } catch (Exception exception) {
            throw new RuntimeException("No bun with given index was found");
        }
    }

    public static Bun returnRandomBun() {
        Random random = new Random();
        int index = random.nextInt(AVAILABLE_BUNS.size());
        return AVAILABLE_BUNS.get(index);
    }

    public static Ingredient returnIngredientByIndex(int index) {
        try {
            return AVAILABLE_INGREDIENTS.get(index);
        } catch (Exception exception) {
            throw new RuntimeException("No ingredient with given index was found");
        }
    }

    public static Ingredient returnRandomIngredient() {
        Random random = new Random();
        int index = random.nextInt(AVAILABLE_INGREDIENTS.size());
        return AVAILABLE_INGREDIENTS.get(index);
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
        return FAKER.funnyName().name();
    }

    public static String returnRandomIngredientName() {
        return FAKER.twinPeaks().character();
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
