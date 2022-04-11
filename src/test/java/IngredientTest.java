import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Database database = new Database();
    List<Ingredient> ingredients = database.availableIngredients();

    int indexIngredient = RandomUtils.nextInt(0, 6);

    Ingredient ingredient = ingredients.get(indexIngredient);

    @Test
    public void ingredientNameTest() {
        assertEquals(ingredients.get(indexIngredient).name, ingredient.getName());
    }

    @Test
    public void ingredientPriceTest() {
        assertEquals(ingredients.get(indexIngredient).price, ingredient.getPrice(), 0);
    }

    @Test
    public void ingredientTypeTest() {
        assertEquals(ingredients.get(indexIngredient).type, ingredient.getType());
    }
}
