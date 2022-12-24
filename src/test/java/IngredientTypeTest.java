import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType testType;
    private final String name;

    public IngredientTypeTest(IngredientType testType, String name) {
        this.testType = testType;
        this.name = name;
    }

    @Parameterized.Parameters(name = "Test values: Type ingredient - {0} Name - {1}")
    public static Object[][] getIngredientsData() {
        return new Object[][]{
                {FILLING, "FILLING"},
                {SAUCE, "SAUCE"}
        };
    }

    @Test
    public void testIngredientTypeName() {
        assertEquals("Incorrect type name of ingredient", name, testType.name());
    }
}