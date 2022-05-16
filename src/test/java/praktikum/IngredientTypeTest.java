package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void getSauceTypeTest() {
        IngredientType sauce = IngredientType.SAUCE;
        String expectedType = "SAUCE";
        String actualType = sauce.name();
        assertEquals("тип для Souce не совпал", expectedType, actualType);
    }

    @Test
    public void getFillingTypeTest() {
        IngredientType filling = IngredientType.FILLING;
        String expectedType = "FILLING";
        String actualType = filling.name();
        assertEquals("тип для Souce не совпал", expectedType, actualType);
    }
}