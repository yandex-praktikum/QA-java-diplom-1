import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import java.util.EnumSet;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    IngredientType expectedType;

    public IngredientTypeTest(IngredientType expectedType) {
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {IngredientType.SAUCE},
                {IngredientType.FILLING},
        };
    }

    @Test
    public void IngredientTypeContainsCorrectEnum() {

        assertTrue(EnumSet.allOf(IngredientType.class).contains(expectedType));
    }
}