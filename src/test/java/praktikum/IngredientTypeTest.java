package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType type;
    private final IngredientType expected;

    public IngredientTypeTest(IngredientType type, IngredientType expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{0} - передаем тип ингредиента, {1} - получаем ожидаемый результат")
    public static Object[][] getIngredientType() {
        Database database = new Database();
        return new Object[][]{
                {database.availableIngredients().get(2).getType(), SAUCE},
                {database.availableIngredients().get(3).getType(), FILLING},
                {null, null}

        };
    }

    @Test
    public void shouldGetAType() {

        IngredientType actual = new Ingredient(type, "", 100).getType();
        assertEquals("Тип ингредиента соответствует ожидаемому", expected, actual);

    }
}
