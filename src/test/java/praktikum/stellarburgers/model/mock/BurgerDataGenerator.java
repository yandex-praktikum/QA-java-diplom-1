package praktikum.stellarburgers.model.mock;

import praktikum.stellarburgers.model.Bun;
import praktikum.stellarburgers.model.Database;
import praktikum.stellarburgers.model.Ingredient;
import praktikum.stellarburgers.model.IngredientType;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

import static praktikum.stellarburgers.model.IngredientType.FILLING;
import static praktikum.stellarburgers.model.IngredientType.SAUCE;

public class BurgerDataGenerator {
    public static Bun getRandomBun() {
        Bun randomBun = null;
        Database database = new Database();
        List<Bun> buns = database.availableBuns();

        int bunsSize = buns.size();
        if (bunsSize > 0) {
            Random rn = new Random();
            int randomNumber = rn.nextInt(bunsSize);
            randomBun = buns.get(randomNumber);
        }
        return randomBun;
    }

    private static Ingredient getRandomIngredient(IngredientType type) {
        Ingredient randomIngredient = null;
        Database database = new Database();
        List<Ingredient> ingredients = database
                .availableIngredients()
                .stream()
                .filter(ingredient -> Objects.equals(ingredient.type, type))
                .collect(Collectors.toList());
        int ingredientsSize = ingredients.size();
        if (ingredientsSize > 0) {
            Random rn = new Random();
            int randomNumber = rn.nextInt(ingredientsSize);
            randomIngredient = ingredients.get(randomNumber);
        }
        return randomIngredient;
    }

    public static Ingredient getRandomSauce() {
        return getRandomIngredient(SAUCE);
    }

    public static Ingredient getRandomFilling() { return getRandomIngredient(FILLING); }

    public static Object[] getRandomIngredientData(IngredientType type) {
        Ingredient ingredient = Objects.equals(type, SAUCE)
                ? getRandomSauce()
                : getRandomFilling();
                return new Object[] { ingredient.getType(), ingredient.getName(), ingredient.getPrice() };
    }
}
