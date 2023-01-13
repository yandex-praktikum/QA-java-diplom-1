import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    final String FILLING = "dinosaur";
    final int FILLING_PRICE = 200;

    Ingredient ingredient = new Ingredient(IngredientType.FILLING, FILLING, FILLING_PRICE);

    @Test
    public void getPriceTest() {
        float expected = FILLING_PRICE;
        float actual = ingredient.getPrice();
        assertEquals("Not correct price",expected, actual, 0);
    }

    @Test
    public void getNameTest() {
        String expected = FILLING;
        String actual = ingredient.getName();
        assertEquals("Not correct name", expected, actual);
    }

    @Test
    public void getTypeTest() {
        IngredientType expected = IngredientType.FILLING;
        IngredientType actual = ingredient.getType();
        assertEquals("Not correct type of ingredient", expected, actual);
    }
}