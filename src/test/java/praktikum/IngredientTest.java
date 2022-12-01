package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest extends BaseTestData{

    Ingredient onion = new Ingredient(IngredientType.FILLING, testIngredientName1, testIngredientPrice1);
    Ingredient mayo = new Ingredient(IngredientType.SAUCE, testIngredientName2, testIngredientPrice2);

    @Test
    public void getPrice() {
        assertEquals(testIngredientPrice1, onion.getPrice(), 0);
    }

    @Test
    public void getName() {
        assertEquals(testIngredientName1, onion.getName());

    }

    @Test
    public void getType() {
        assertEquals(IngredientType.FILLING, onion.type);
    }
}