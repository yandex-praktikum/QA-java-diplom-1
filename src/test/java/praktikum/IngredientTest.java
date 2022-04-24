package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    public IngredientType type;
    public String name;
    public float price;
    public Ingredient ingredient;

    @Before
    public void setUp() throws Exception {
        name = RandomStringUtils.randomAlphabetic(5);
        price = RandomUtils.nextInt(5, 500);
        int ingredientTypeChoice = RandomUtils.nextInt(0, 2);
        if (ingredientTypeChoice == 0) {
            type = SAUCE;
        } else {
            type = FILLING;
        }
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPrice() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals(type, ingredient.getType());
    }
}