package praktikum;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    @DisplayName("Тест на проверку типа SAUCE")
    public void getSauceTypeTest() {
        IngredientType sauce = IngredientType.SAUCE;
        String expectedType = "SAUCE";
        String actualType = sauce.name();
        assertEquals(actualType, expectedType);
    }

    @Test
    @DisplayName("Тест на проверку типа FILLING")
    public void getFillingTypeTest() {
        IngredientType filling = IngredientType.FILLING;
        String expectedType = "FILLING";
        String actualType = filling.name();
        assertEquals(actualType, expectedType);
    }

}