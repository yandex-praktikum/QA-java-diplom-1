import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedIngredientGetTypeTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public ParameterizedIngredientGetTypeTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "", 0},
                {IngredientType.FILLING, "", 0},
        };
    }
    @Test
    public void getPriceReturnsCorrectType() {
        Ingredient ingredient = new Ingredient(type, name, price);

        IngredientType actual = ingredient.getType();

        assertEquals("Returns incorrect ingredient type", type, actual);
    }
}
