package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    private final String name;
    private final float price;
    private IngredientType type;

    public IngredientParametrizedTest(IngredientType type, String name, float price) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientParametrizedTestData() {
        return new Object[][]{
                {IngredientType.SAUCE, "KolyaevBun" + new Random().nextInt(10), new Random().nextFloat()},
                {IngredientType.FILLING, "KolyaevBun" + new Random().nextInt(10), new Random().nextFloat()}
        };
    }

    @Test
    public void checkGetTypeReturnsTypeFromParameters() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType expectedType = ingredient.getType();
        assertEquals(expectedType, type);
    }
}
