package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void prepareData() {
        ingredient = new Ingredient( IngredientType.SAUCE, "Марсианский", 156.5f);
    }

    @Test
    public void getIngredientPriceReturnCorrectPrice() {
        float expectedIngredientPrice = 156.5f;
        float actualIngredientPrice = ingredient.getPrice();
        assertEquals(expectedIngredientPrice, actualIngredientPrice, 0.0);
    }

    @Test
    public void getIngredientNameReturnCorrectName() {
        String expectedIngredientName = "Марсианский";
        String actualIngredientName = ingredient.getName();
        assertEquals(expectedIngredientName, actualIngredientName);
    }

    @Test
    public void getIngredientTypeReturnCorrectType() {
        IngredientType expectedIngredientType = IngredientType.SAUCE;
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals(expectedIngredientType, actualIngredientType);
    }
}
