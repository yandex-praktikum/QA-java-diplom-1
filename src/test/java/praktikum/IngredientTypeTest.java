package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.EnumSet;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    IngredientType expectedType;

    public IngredientTypeTest(IngredientType expectedType) {
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {IngredientType.SAUCE},
                {IngredientType.FILLING},
        };
    }

    @Test
    public void IngredientTypeContainsCorrectValuesTest() {

        assertTrue(EnumSet.allOf(IngredientType.class).contains(expectedType));
    }
}