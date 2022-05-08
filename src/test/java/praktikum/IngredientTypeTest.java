package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType type;
    private final String name;


    public IngredientTypeTest(String name, IngredientType type) {
        this.type = type;
        this.name = name;

    }

    @Parameterized.Parameters(name = "Test value = {1}")
    public static Object[][] getIngredientTypeData() {
        return new Object[][]{
                {"SAUCE", IngredientType.SAUCE},
                {"FILLING", IngredientType.FILLING}
        };
    }

    @Test
    public void checkIngredientTypeName() {
        assertEquals(type.name(), name);
    }
}