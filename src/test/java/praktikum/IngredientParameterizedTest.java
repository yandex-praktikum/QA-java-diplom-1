package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final IngredientType type;
    private final IngredientType expectedType;

    public IngredientParameterizedTest(IngredientType type, IngredientType expectedType) {
        this.type = type;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, SAUCE},
                {FILLING, FILLING},
        };
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type, "что-то съедобное",40F);
        IngredientType actual = ingredient.getType();
        assertEquals(expectedType,actual) ;
    }
}
