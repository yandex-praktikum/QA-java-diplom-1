package praktikum;

import java.util.List;
import java.util.Random;

class CreateRandomIngredient {
    Database db = new Database();
    public final List<Ingredient> ingredients = db.availableIngredients();

    public Ingredient getIngredients() {
        return ingredients.get(new Random().nextInt(ingredients.size()));
    }
}
