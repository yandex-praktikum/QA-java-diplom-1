package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTests {
    private final String expected;
    private final IngredientType type;

    public IngredientTypeTests(IngredientType type, String expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTests() {
        return new Object[][]{
                {IngredientType.FILLING, "FILLING"},
                {IngredientType.SAUCE, "SAUCE"},
        };
    }

    @Test
    public void ingredientTypeTest() {
        IngredientType actualType = type;
        Assert.assertEquals("Values should match", actualType.name(), expected);
    }
}
