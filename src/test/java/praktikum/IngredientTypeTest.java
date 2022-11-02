package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String name;

    public IngredientTypeTest(String name) {
        this.name = name;
    }

    public static boolean checkEnumContainsValue(String test) {
        for (IngredientType type : IngredientType.values()) {
            if (type.name().equals(test)) {
                return true;
            }
        }
        return false;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientParametrizedTestData() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void checkIngredientTypeContainsValue() {
        assertEquals(true, checkEnumContainsValue(name));
    }
}
