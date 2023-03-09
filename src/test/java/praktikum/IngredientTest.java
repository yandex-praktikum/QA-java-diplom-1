package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest extends BaseTest {

    Ingredient ingredient;

    float price = RandomUtils.nextFloat();
    String name = RandomStringUtils.randomAlphabetic(8);
    IngredientType ingredientType = IngredientType.SAUCE;

    @Before
    public void setUp() throws Exception {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void getPrice() {
        assertEquals("Неверная стоимость ингридиента", price, ingredient.getPrice(), FLOAT_DELTA);
    }

    @Test
    public void getName() {
        assertEquals("Неверное название ингридиента", name, ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals("Неверный тип ингридиента", ingredientType, ingredient.getType());
    }
}