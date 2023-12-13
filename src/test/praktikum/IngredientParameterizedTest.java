package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final String testType;
    public IngredientParameterizedTest(String typeName) {
        this.testType = typeName;
    }
    @Parameterized.Parameters
    public static Object[][] testParameters() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"}
        };
    }
    @Test
    public void isIngredientTypeEqual() {
        assertEquals(IngredientType.valueOf(testType.toUpperCase()).toString(), testType);
    }
}