package praktikum;

import java.util.ArrayList;
import java.util.List;

import static praktikum.Constant.*;

/**
 * Класс с методами по работе с базой данных.
 */
public class Database {

    private final List<Bun> buns = new ArrayList<>();
    private final List<Ingredient> ingredients = new ArrayList<>();

    public Database() {
        buns.add(new Bun( BLACK_BUN, BLACK_PRICE));
        buns.add(new Bun(WHITE_BUN, WHITE_PRICE));
        buns.add(new Bun(RED_BUN, RED_PRICE));

        ingredients.add(new Ingredient(IngredientType.SAUCE, HOT_SAUCE, HOT_SAUCE_PRICE));
        ingredients.add(new Ingredient(IngredientType.SAUCE, SOUR_CREAM, SOUR_CREAM_PRICE));
        ingredients.add(new Ingredient(IngredientType.SAUCE, CHILI_SAUCE, CHILI_SAUCE_PRICE));

        ingredients.add(new Ingredient(IngredientType.FILLING, CUTLET, CUTLET_PRICE));
        ingredients.add(new Ingredient(IngredientType.FILLING, DINOSAUR, DINOSAUR_PRICE));
        ingredients.add(new Ingredient(IngredientType.FILLING, SAUSAGE, SAUSAGE_PRICE));
    }

    public List<Bun> availableBuns() {
        return buns;
    }

    public List<Ingredient> availableIngredients() {
        return ingredients;
    }

}