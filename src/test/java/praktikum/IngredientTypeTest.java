package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    String expectedIngredientType;
    String actualType;

    public IngredientTypeTest(String expectedIngredientType, String actualType) {
        this.expectedIngredientType = expectedIngredientType;
        this.actualType = actualType;
    }

    @Parameterized.Parameters(name = "{index}:IngredientType {1} exist")
    public static Object[][] getIngredientType() {
        return new Object[][]{
                {"SAUCE", "SAUCE"},
                {"FILLING", "FILLING"}
        };
    }

    @Test
    public void fillingTest() {
        assertEquals(expectedIngredientType, IngredientType.valueOf(actualType).toString());
    }

}