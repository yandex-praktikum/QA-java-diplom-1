package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final int index;
    private final IngredientType type;
    private final boolean expectedResult;

    public IngredientTypeTest(int index, IngredientType type, boolean expectedResult) {
        this.index = index;
        this.type = type;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][] {
                {0, SAUCE, true},
                {1, FILLING, true},
        };
    }

    @Test
    public void checkTheCorrectTypeOfIngredient() {
        assertEquals("Ингредиента не существует", IngredientType.values()[index].equals(type), expectedResult);
    }
}
