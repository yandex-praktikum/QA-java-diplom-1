import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private IngredientType ingridient;
    private String result;

    public IngredientTypeTest(IngredientType ingridient, String result) {
        this.ingridient = ingridient;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                { IngredientType.SAUCE, "SAUCE" },
                { IngredientType.FILLING, "FILLING" },
        };
    }

    @Test
    public void validateIngredient() {
        assertThat(ingridient.toString(), is(result));
    }
}
