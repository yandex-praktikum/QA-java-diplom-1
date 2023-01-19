import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String name;
    private final IngredientType type;
    private final float price;

    public IngredientTypeTest(String name, IngredientType type, float price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Ingredient type: {0}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"barbecue", SAUCE, 56f},
                {"pork", FILLING, 123f},
                {"chicken", FILLING, 100f},
        };
    }

    @Test
    public void checkIngredientType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Not correct type of ingredient", type, ingredient.getType());
    }

}