import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public record IngredientTypeTest(String expectedType, IngredientType actualType) {

    @Parameterized.Parameters
    public static Object[][] setIngredient() {
        return new Object[][]{
                {"SAUCE", SAUCE},
                {"FILLING", FILLING}
        };
    }

    @Test
    public void testGetIngredientType() {
        Assert.assertEquals(IngredientType.valueOf(expectedType), actualType);
    }
}
