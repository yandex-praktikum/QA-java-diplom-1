import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    public String type;
    public boolean expectedResult;

    public IngredientTypeTest(String type, boolean expectedResult) {
        this.type = type;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getParamData() {
        return new Object[][]{
                {"FILLING", true},
                {"SAUCE", true},
        };
    }

    @Test
    public void testIngredientType() {
        assertEquals(type, IngredientType.valueOf(type).toString());
    }

}
