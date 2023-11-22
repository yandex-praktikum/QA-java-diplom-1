package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    Database database = new Database();

    Ingredient ingredient = new Ingredient(database.availableIngredients().get(0).getType(), database.availableIngredients().get(0).getName(), database.availableIngredients().get(0).getPrice());

    @Test
    public void getPrice() {

        Assert.assertEquals(100F, ingredient.getPrice(), 0);

    }

    @Test
    public void getName() {

        Assert.assertEquals("hot sauce", ingredient.getName());

    }

    @Test
    public void getType() {

        Assert.assertEquals(SAUCE, ingredient.getType());

    }
}
