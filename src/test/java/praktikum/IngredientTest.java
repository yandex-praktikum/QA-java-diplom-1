package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    //Проверяем метод getPrice()
    @Test
    public void getPriceCheck() {
        float expectedResult = 100;
        float actualResult = ingredient.getPrice();
        assertEquals("Price is incorrect", expectedResult, actualResult, 0);
    }

    //Проверяем метод getName()
    @Test
    public void getNameCheck() {
        String expectedResult = "hot sauce";
        String actualResult = ingredient.getName();
        assertEquals("String is incorrect", expectedResult, actualResult);
    }

    //Проверяем метод getType()
    @Test
    public void getTypeCheck() {
        IngredientType expectedResult = IngredientType.SAUCE;
        IngredientType actualResult = ingredient.getType();
        assertEquals("IngredientType is incorrect", expectedResult, actualResult);
    }
}