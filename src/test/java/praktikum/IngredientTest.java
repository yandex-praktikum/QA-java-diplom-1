package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private final String name = RandomStringUtils.randomAlphabetic(8);
    private final Float price = Float.valueOf(RandomStringUtils.randomNumeric(3));
    IngredientType type;

    @Test
    public void getPriceReturnEnteredPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float returnValue = ingredient.getPrice();
        assertEquals(price, returnValue, 0.0);
    }

    @Test
    public void getNameReturnEnteredName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String returnValue = ingredient.getName();
        assertEquals(name, returnValue);
    }

    @Test
    public void getTypeReturnEnteredType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType expectedType = ingredient.getType();
        assertEquals(type, expectedType);
    }
}