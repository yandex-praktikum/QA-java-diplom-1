package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {
    IngredientType[] expectedResult = {SAUCE, FILLING};
    IngredientType[] actualResult;

    @Test
    public void testValues() {
        actualResult = IngredientType.values();
        assertEquals("Внимание! Список типов ингредиентов сформирован некорректно", expectedResult, actualResult);
    }

    @Test
    public void testValueOf() {
        assertEquals("Внимание! Ингредиентов тип SAUCE нет в списке", SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals("Внимание! Ингредиентов тип FILLING нет в списке", FILLING, IngredientType.valueOf("FILLING"));
    }
}


