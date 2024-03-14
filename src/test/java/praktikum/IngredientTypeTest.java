package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String ingredientType;

    public IngredientTypeTest(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "Название типа ингредиента: {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void getIngredientType() {
        assertEquals("Такого ингредиента нет", ingredientType, IngredientType.valueOf(ingredientType).toString());
    }
}