package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {

    private final IngredientType type;
    private static final String NAME = "Кетчуп";
    private static final float PRICE = 0.5F;

    public IngredientTypeParameterizedTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {SAUCE},
                {FILLING},
        };
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, NAME, PRICE);
        IngredientType actualType = ingredient.getType();
        assertEquals(type, actualType);
    }
}
