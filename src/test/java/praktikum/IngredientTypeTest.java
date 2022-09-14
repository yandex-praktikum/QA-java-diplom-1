package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType type;
    private final IngredientType expectedType;

    public IngredientTypeTest(IngredientType type, IngredientType expectedType) {
        this.type = type;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getIngredientType() {
        return new Object[][] {
                { IngredientType.SAUCE, IngredientType.SAUCE},
                { IngredientType.FILLING, IngredientType.FILLING},
        };
    }

    @Test
    public void checkGetTypeForIngredient(){

        Ingredient ingredient = new Ingredient(type,"Onion", 33.0f);
        IngredientType actualType = ingredient.getType();

        Assert.assertEquals("Ingredient name is incorrect", expectedType, actualType);

    }

}
