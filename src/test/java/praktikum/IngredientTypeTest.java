package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType ingredientType;

    public IngredientTypeTest(IngredientType type) {
        this.ingredientType = type;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][] {
                {IngredientType.SAUCE},
                {IngredientType.FILLING},
        };
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals("Тип не совпадает",ingredientType, IngredientType.valueOf(ingredientType.name()));
    }
}
