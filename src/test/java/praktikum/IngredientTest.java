package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest extends BaseTestData{

    Ingredient onion = new Ingredient(IngredientType.FILLING, testFillingName, testFillingPrice);
    Ingredient mayo = new Ingredient(IngredientType.SAUCE, testSauceName, testSaucePrice);

    @Test
    public void getPrice() {
        assertEquals(testFillingPrice, onion.getPrice(), 0);
    }

    @Test
    public void getName() {
        assertEquals(testFillingName, onion.getName());

    }

    @Test
    public void getType() {
        assertEquals(IngredientType.FILLING, onion.getType());
    }
}