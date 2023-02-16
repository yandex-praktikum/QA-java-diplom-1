import praktikum.IngredientType;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {

    private final IngredientType ingredientType;
    private final String stringIngredientType;

    public IngredientTypeParameterizedTest(IngredientType ingredientType, String stringIngredientType) {
        this.ingredientType = ingredientType;
        this.stringIngredientType = stringIngredientType;
    }


    @Parameterized.Parameters(name = "Набор параметров {index}, параметры: {0}")
    public static Object[][] getParameters() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }
    @Test
    public void valueOfReturnCorrectEnum() {
        Assert.assertEquals("Результат не корректный, ожидалось: " + ingredientType.toString(),ingredientType, IngredientType.valueOf(stringIngredientType));
    }
}