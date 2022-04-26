import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {

    private final String expectedIngredient;

    public IngredientTypeParameterizedTest(String expectedIngredient) {
        this.expectedIngredient = expectedIngredient;
    }

    @Parameterized.Parameters(name = "{index}: \"expectedIngredient\": {0};")
    public static Object[][] getSampleIngredientType() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void checkListOfIngredientTypes() {
        String actualIngredient;
        try {
            actualIngredient = IngredientType.valueOf(expectedIngredient).name();
        } catch (Exception ex) {
            actualIngredient = "";
        }
        assertEquals(expectedIngredient, actualIngredient);
    }

}