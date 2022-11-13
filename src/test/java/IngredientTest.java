import praktikum.Ingredient;
import praktikum.IngredientType;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    private Ingredient ingredient;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {IngredientType.FILLING, "КосмоСыр", 7.50f},
                {IngredientType.SAUCE, "КосмоКетчуп", 3.75f}
        };
    }

    @Before
    public void initIngredient() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void getNameReturnIngredientName() {
        Assert.assertEquals("Результат не соответствует: " + name, name, ingredient.getName());
    }

    @Test
    public void getPriceReturnIngredientPrice() {
        Assert.assertEquals("Результат не соответствует: " + price, price, ingredient.getPrice(), 0.01f);
    }

    @Test
    public void getTypeReturnIngredientType() {
        Assert.assertEquals("Результат не соответствует: " + ingredientType.toString(), ingredientType, ingredient.getType());
    }
}