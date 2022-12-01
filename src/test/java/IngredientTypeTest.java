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

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTypeTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "IngredientType: {index}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {SAUCE, "hot sauce" , 100},
                {FILLING, "sausage", 300}
        };
    }

    @Test
    public void getIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Type is incorrect", type, ingredient.getType());
    }
}

