import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private static IngredientType typeEnum;
    private String ingredientType;
    private boolean expectedValue;

    public IngredientTypeTest(String ingredientType, IngredientType typeEnum, boolean expectedValue) {
        this.ingredientType = ingredientType;
        this.typeEnum = typeEnum;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters(name = "Проверка перечисления типов ингредиентов. Тестовые данные: {0} {1} {2}")
    public static Object[][] GetIngredientType() {
        return new Object[][]{
                {"SAUCE", IngredientType.SAUCE, true},
                {"FILLING", IngredientType.FILLING, true},
                {"SAUCEFILLING", IngredientType.FILLING, false},
        };
    }

    @Test
    public void isIngredientTypeEnumEqualsToValues() {
        boolean actualValue = typeEnum.toString().equals(ingredientType);
        assertEquals(expectedValue, actualValue);
    }

}
