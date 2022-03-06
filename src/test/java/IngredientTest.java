import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.*;

public class IngredientTest {

    private IngredientType ingredientType = SAUCE;
    private String ingredientName = "Булочка";
    private float ingredientPrice = 50.5F;

    @Test
    public void shouldGetIngredientPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        Assert.assertEquals(ingredientPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void shouldGetIngredientName() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        Assert.assertEquals(ingredientName, ingredient.getName());
    }

}
