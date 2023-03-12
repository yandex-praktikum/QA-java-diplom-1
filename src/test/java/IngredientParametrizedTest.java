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
    String name = "Булка";
    float price = 123;

    private IngredientType type;

    public IngredientParametrizedTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getTypeData() {
        return new Object[][] {
                {SAUCE},
                {FILLING},
        };
    }

    @Test
    public void testGetTypeReturnType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
}