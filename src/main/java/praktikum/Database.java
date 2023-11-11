package praktikum;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс с методами по работе с базой данных.
 */
public class Database {

    private final List<Bun> buns = new ArrayList<>();
    private final List<Ingredient> ingredients = new ArrayList<>();

    public Database() {
        buns.add(new Bun("черная булочка", 100));
        buns.add(new Bun("белая булочка", 200));
        buns.add(new Bun("красная булочка", 300));

        ingredients.add(new Ingredient(IngredientType.SAUCE, "острый соус", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "сметана", 200));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "соус чили", 300));

        ingredients.add(new Ingredient(IngredientType.FILLING, "котлета", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "сыр", 200));
        ingredients.add(new Ingredient(IngredientType.FILLING, "колбаса", 300));
    }

    public List<Bun> availableBuns() {
        return buns;
    }

    public List<Ingredient> availableIngredients() {
        return ingredients;
    }

}