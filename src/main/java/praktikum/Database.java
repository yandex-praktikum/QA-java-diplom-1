package praktikum;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private final List<Bun> buns = new ArrayList<>();
    private final List<Ingredient> ingredients = new ArrayList<>();

    public Database() {
        buns.add(new Bun("черная булочка", 100));
        buns.add(new Bun("белая булочка", 200));
        buns.add(new Bun("красная булочка", 300));

        ingredients.add(new Ingredient(IngredientType.соус, "острый соус", 100));
        ingredients.add(new Ingredient(IngredientType.соус, "сметана", 200));
        ingredients.add(new Ingredient(IngredientType.соус, "соус чили", 300));

        ingredients.add(new Ingredient(IngredientType.начинка, "котлета", 100));
        ingredients.add(new Ingredient(IngredientType.начинка, "сыр", 200));
        ingredients.add(new Ingredient(IngredientType.начинка, "колбаса", 300));
    }

    public List<Bun> availableBuns() {
        return buns;
    }

    public List<Ingredient> availableIngredients() {
        return ingredients;
    }
}