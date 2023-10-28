package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String expectedType;
    private final IngredientType actualType;

    public IngredientTypeTest(String expectedType, IngredientType actualType) {
        this.expectedType = expectedType;
        this.actualType = actualType;
    }

    @Parameterized.Parameters
    public static Object[][] setIngredient() {
        return new Object[][] {
                {"SAUCE", SAUCE},
                {"FILLING", FILLING}
        };
    }

    @Test
    public void testIngredientType() {
        Assert.assertEquals(IngredientType.valueOf(expectedType), actualType);
    }
}