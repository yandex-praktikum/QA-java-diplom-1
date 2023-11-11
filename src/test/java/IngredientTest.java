import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static praktikum.IngredientType.начинка;
import static praktikum.IngredientType.соус;

public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(начинка, "Что то вкусное", 20);
    }

    @Test
    public void ingredientsTest() {
        IngredientType expected = начинка;
        IngredientType actual = ingredient.getType();

        assertEquals("Проверим что правильные ингредиенты", expected, actual);
    }

    @Test
    public void incorrectIngredientsTest() {
        IngredientType expected = соус;
        IngredientType actual = ingredient.getType();

        assertNotEquals("Проверим что неправильные ингредиенты", expected, actual);
    }

    @Test
    public void nameTest() {
        String expected = "Что то вкусное";
        String actual = ingredient.getName();

        assertEquals("Проверим что правильное название", expected, actual);
    }

    @Test
    public void incorrectNameTest() {
        String expected = "Что то невкусное";
        String actual = ingredient.getName();

        assertNotEquals("Проверим что неправильное название", expected, actual);
    }

    @Test
    public void priceTest() {
        int expected = 20;
        int actual = ingredient.getPrice();
        assertEquals("Проверим правильную цену", expected, actual);
    }

    @Test
    public void incorrectPriceTest() {
        int expected = 40;
        int actual = ingredient.getPrice();
        assertNotEquals("Проверим неправильную цену", expected, actual);
    }
}