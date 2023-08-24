package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;

    public IngredientTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "Ингредиент: {0}")
    public static Object[][] createTestData() {
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING},

        };
    }
    @Test
    public void checkIngredientType() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));}
}