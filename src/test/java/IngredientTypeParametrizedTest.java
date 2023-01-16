import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class IngredientTypeParametrizedTest {
    public String type;
    public boolean expectedResult;

    public IngredientTypeParametrizedTest(String type, boolean expected) {
        this.type = type;
        this.expectedResult = expected;
    }

    @Parameterized.Parameters
    public static Object[][] IngredientTypeData() {
        return new Object[][]{
                {"SAUCE", true},
                {"FILLING", true},
                {"Молочная каша", false},
                {" ", false}
        };
    }

    @Test
    public void CheckIngredientType() {
        boolean actualResult = true;
        try {
            String expected = type;
            String actual = IngredientType.valueOf(type).toString();
            assertEquals(expected, actual);
        } catch (IllegalArgumentException | NullPointerException exception) {
            actualResult = false;
        }
        assertEquals(expectedResult, actualResult);
    }


}
