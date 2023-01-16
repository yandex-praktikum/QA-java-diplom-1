import org.junit.Test;
import org.mockito.Spy;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Spy
    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Мясная котлета", 99.00f);

    @Test
    public void getPriceTest() {
        float expected = 99.00f;
        float actual = ingredient.getPrice();
        assertEquals(expected, actual, 0.00f);
    }

    @Test
    public void getNameTest() {
        String expected = "Мясная котлета";
        String actual = ingredient.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest() {
        IngredientType expected = IngredientType.FILLING;
        IngredientType actual = ingredient.getType();
        assertEquals(expected, actual);
    }
}
