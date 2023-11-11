import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;

public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(FILLING, "Что то вкусное", 10);
    }

    @Test
    public void ingredientsTest() {
        IngredientType expected = FILLING;
        IngredientType actual = ingredient.getType();

        Assert.assertEquals("Проверим ингредиенты", expected, actual);
    }

    @Test
    public void nameTest() {
        String expected = "Что то вкусное";
        String actual = ingredient.getName();

        Assert.assertEquals("Проверим название", expected, actual);
    }

    @Test
    public void priceTest() {
        int expected = 10;
        int actual = ingredient.getPrice();
        Assert.assertEquals("Проверим цену", expected, actual);
    }
}