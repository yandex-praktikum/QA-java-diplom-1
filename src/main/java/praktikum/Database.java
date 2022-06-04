package praktikum;

import java.util.ArrayList;
import java.util.List;

import static praktikum.IngredientType.*;

/**
 * Класс с методами по работе с базой данных.
 */
public class Database {

    private final List<Bun> buns = new ArrayList<>();
    private final List<Ingredient> ingredients = new ArrayList<>();

    public Database() {
        buns.add(new Bun("black bun", 100));
        buns.add(new Bun("white bun", 200));
        buns.add(new Bun("red bun", 300));

        ingredients.add(new Ingredient(SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(SAUCE, "chili sauce", 300));

        ingredients.add(new Ingredient(FILLING, "cutlet", 100));
        ingredients.add(new Ingredient(FILLING, "dinosaur", 200));
        ingredients.add(new Ingredient(FILLING, "sausage", 300));
    }

    public List<Bun> availableBuns() {
        return buns;
    }

    public List<Ingredient> availableIngredients() {
        return ingredients;
    }

}