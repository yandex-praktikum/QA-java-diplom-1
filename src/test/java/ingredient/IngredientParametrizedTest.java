package ingredient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    private final String name = "Бургер";
    private final float price = 325;
    private final IngredientType type;

    public IngredientParametrizedTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Object[][] getType() {
        return new Object[][]{
                {SAUCE,},
                {FILLING,}
        };
    }

    @Test
    public void getTypeReturnType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
}
