package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    public String type;
    public boolean expectedResult;

    public IngredientTypeTest(String type, boolean expected) {
        this.type = type;
        this.expectedResult = expected;
    }

    @Parameterized.Parameters(name = "{index} -> {0}: {1} ")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"SAUCE", true},
                {"FILLING", true},
                {"Unknown", false},
                {" ", false},
                {"", false},
                {null, false}
        };
    }

    @Test
    public void testIngredientType() {
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
