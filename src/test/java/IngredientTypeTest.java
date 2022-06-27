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
    private String name;
    private IngredientType type;
    private float price;

    public IngredientTypeTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Ingredient type: {0}")
    public static Object[][] testData() {
        return new Object[][]{
                {SAUCE, "BBQ", 120},
                {FILLING, "Доп.котлета", 229},
        };
    }

    @Test
    public void IngredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Неккоректное значение", type, ingredient.getType());
    }

}
