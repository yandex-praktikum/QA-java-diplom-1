package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)

public class IngredientTest {
    private IngredientType ingredientType;
    private String ingredientName;
    private float ingredientPrice;
    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][] {
                {IngredientType.FILLING, "Syrik", 399},
                {IngredientType.SAUCE, "Chilly", 198},
        };
    }
    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        Assert.assertEquals(ingredientPrice, ingredient.getPrice(), 0.000000000000001);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        Assert.assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        Assert.assertEquals(ingredientType, ingredient.getType());
    }
}