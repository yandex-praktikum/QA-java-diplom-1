package praktikum;

import static praktikum.IngredientType.SAUCE;
import java.util.ArrayList;
import java.util.List;

public class BurgerCreated {
    public static Burger burgerCreate = new Burger();
    public static List<Ingredient> ingredients = new ArrayList<>();

    public static Burger create() {
        burgerCreate.setBuns(new Bun("black bun", 100));
        burgerCreate.addIngredient(new Ingredient(SAUCE, "chili sauce", 300));
        burgerCreate.addIngredient(new Ingredient(SAUCE, "sour cream", 200));
        return burgerCreate;
    }

    public static void delete() {
            burgerCreate.ingredients.clear();
    }
}