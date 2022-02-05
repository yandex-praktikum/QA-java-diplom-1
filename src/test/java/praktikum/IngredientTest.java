package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {

    private IngredientType ingredientType;
    private String ingredientName;
    private float ingredientPrice;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredientType = IngredientType.SAUCE;
        ingredientName = "ingredientName";
        ingredientPrice = 49.15f;
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Test
    public void testGetType() {
        Assert.assertEquals("Ingredient types are not equal",
                ingredientType, ingredient.getType());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Ingredient names are not equal",
                ingredientName, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals("Ingredient prices are not equal",
                ingredientPrice, ingredient.getPrice(), 0);
    }
}
