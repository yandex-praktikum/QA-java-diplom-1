import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientGetPriceParametrizedTest {

    private static final Object SAUCE = IngredientType.SAUCE;
    private static final Object FILLING = IngredientType.FILLING;
    private final Object type;
    private final String name;
    private final float price;
    private final float expected;

    public IngredientGetPriceParametrizedTest(Object type, String name, float price, float expected) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {SAUCE, "кетчуп", 200, 200},
                {FILLING, "свинина", 400, 400},
        };
    }

    @Test
    public void getPrice() throws Exception {
        Ingredient ingredient = new Ingredient((IngredientType) type, name, price);
        float actualPrice = ingredient.getPrice();
        assertEquals("Цена не совпадает!", expected, actualPrice, 0);

    }
}
