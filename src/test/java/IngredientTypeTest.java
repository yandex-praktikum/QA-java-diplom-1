import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private IngredientType type;

    public IngredientTypeTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Object[][] getType() {
        return new Object[][]{
                {IngredientType.FILLING},
                {IngredientType.SAUCE},
        };
    }

    @Test
    public void typeValue() {
        Assert.assertThat(IngredientType.valueOf(String.valueOf(type)), is(notNullValue()));
    }
}
