package praktikum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class IngredientTypeTest {
    @Test
    public void IngredientTypeSauceTest() {
        String actualIngredientType = IngredientType.SAUCE.toString();
        String expectedIngredientType = "SAUCE";
        assertEquals(expectedIngredientType, actualIngredientType, "Значение SAUCE не совпадает");
    }
    @Test
    public void IngredientTypeFillingTest() {
        String actualIngredientType = IngredientType.FILLING.toString();
        String expectedIngredientType = "FILLING";
        assertEquals(expectedIngredientType, actualIngredientType, "Значение FILLING не совпадает");
    }
}