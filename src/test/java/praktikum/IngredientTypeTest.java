package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final int type;
    private final String expected;

    public IngredientTypeTest(int type, String expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{0} = {1}")
    public static Object[][] getType() {
        return new Object[][]{
                {0, "SAUCE"},
                {1, "FILLING"},
        };
    }

    @Test
    public void getIngredientTypeTest() {
        assertEquals(expected, IngredientType.values()[type].name());
    }

}