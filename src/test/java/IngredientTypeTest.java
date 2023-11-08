import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType ingredientType;

    public IngredientTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Object[][] getType() {
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        };
    }
    @Test
    public void testsauceName() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void testfillingName() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}
