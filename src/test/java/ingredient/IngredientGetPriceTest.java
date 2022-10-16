package ingredient;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientGetPriceTest {
    IngredientType type = IngredientType.FILLING;

    String name = "name";
    private final float price;

    public IngredientGetPriceTest(float price) {
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getDataOfBun() {
        return new Object[][]{
                {100},
                {-100},
                {0},
        };
    }

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }
}
