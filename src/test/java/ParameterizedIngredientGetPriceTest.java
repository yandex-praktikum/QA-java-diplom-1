import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedIngredientGetPriceTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public ParameterizedIngredientGetPriceTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "", 300F},
                {IngredientType.SAUCE, "", 99999999.99F},
                {IngredientType.SAUCE, "", -99999999.99F},
                {IngredientType.SAUCE, "", 0.01F},
                {IngredientType.SAUCE, "", -0.01F},
                {IngredientType.SAUCE, "", 0},
        };
    }

    @Test
    public void getPriceReturnsPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);

        float actual = ingredient.getPrice();

        assertEquals("Returns incorrect price", price, actual, 0);
    }
}
