import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final IngredientType type;
    private final IngredientType expected;

    public IngredientParameterizedTest(IngredientType type, IngredientType expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getSumData() {
        return new Object[][]{
                { SAUCE, SAUCE},
                { FILLING, FILLING},

        };
    }
    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, "Test", 134F);
        IngredientType actualType = ingredient.getType();
        assertEquals("Тип не совпадает с ожидаемым значением", expected, actualType);
    }
}

