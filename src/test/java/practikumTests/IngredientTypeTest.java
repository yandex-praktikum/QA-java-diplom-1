package practikumTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType ingredientType;
    private final String stringIngredientType;

    public IngredientTypeTest(IngredientType ingredientType, String stringIngredientType) {
        this.ingredientType = ingredientType;
        this.stringIngredientType = stringIngredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void ReturnsCorrectEnumTypeTest() {
        Assert.assertEquals(ingredientType, IngredientType.valueOf(stringIngredientType));
    }
}
