package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private final static IngredientType TYPE = IngredientType.SAUCE;
    private final static String NAME = "sauce";
    private final static float PRICE = 500;

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(TYPE, NAME, PRICE);

        float actual = ingredient.getPrice();

        assertEquals(0, Float.compare(PRICE, actual));
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(TYPE, NAME, PRICE);

        String actual = ingredient.getName();

        assertEquals(NAME, actual);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(TYPE, NAME, PRICE);

        IngredientType actual = ingredient.getType();

        assertEquals(TYPE, actual);
    }
}
