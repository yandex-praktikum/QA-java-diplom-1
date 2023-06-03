import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeParamTest {
    private final IngredientType ingredientType;
    private final String nameIngregientType;

    public IngredientTypeParamTest(IngredientType ingredientType, String nameIngregientType) {
        this.ingredientType = ingredientType;
        this.nameIngregientType = nameIngregientType;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void returnCorrectEnumType() {
        assertEquals("Ошибка! Неверный тип ингредиента. Ожидается - " + ingredientType, ingredientType, IngredientType.valueOf(nameIngregientType));
    }
}





