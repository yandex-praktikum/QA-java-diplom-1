package praktikum;

import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class IngredientTest {
    public float actualPrice = new Random().nextFloat();
    public String actualName = "KolyaevBun" + new Random().nextInt(10);
    IngredientType type = IngredientType.values()[new Random().nextInt(IngredientType.values().length)];

    @Test
    public void checkGetPriceReturnsFloatFromParameters() {
        Ingredient ingredient = new Ingredient(type, actualName, actualPrice);
        float expectedPrice = ingredient.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void checkGetNameReturnsStringFromParameters() {
        Ingredient ingredient = new Ingredient(type, actualName, actualPrice);
        String expectedName = ingredient.getName();
        assertEquals(expectedName, actualName);
    }

//Это видимо нужно сделать с параметрами, потом переделаю
    @Test
    public void checkGetTypeReturnsTypeFromParameters() {
        Ingredient ingredient = new Ingredient(type, actualName, actualPrice);
        IngredientType expectedType = ingredient.getType();
        assertEquals(expectedType, type);
    }
}
