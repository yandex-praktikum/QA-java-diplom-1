package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeClassParameterizedTest {

    private String expectedType;
    private String actualType;

    public IngredientTypeClassParameterizedTest (String expectedType, String actualType) {
        this.expectedType = expectedType;
        this.actualType = actualType;
    }

    @Parameterized.Parameters (name = " {index} : checkIngredientType {0}, expected EnumValue {1}")
    public static Object[][] getIngredientTypes() {
        return new Object[][] {
                {"SAUCE","SAUCE"},
                {"FILLING","FILLING"}
        };
    }

    @Test
    //проверить список типов ингредиентов
    public void checkIngredientTypes(){
        assertEquals("Ошибка в параметре enum класса IngredientType",expectedType,IngredientType.valueOf(actualType).toString());
    }
}
