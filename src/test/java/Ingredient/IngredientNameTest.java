package Ingredient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

@RunWith(Parameterized.class)
public class IngredientNameTest {

    private final String nameIngredient;
    private final String expected;

    public IngredientNameTest(String nameIngredient, String expected) {
        this.nameIngredient = nameIngredient;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] nameParam() {
        return new Object[][] {
                {"котлета", "котлета"},
                {"Cucumber", "Cucumber"},
                {"Spicy Burger Sauce", "Spicy Burger Sauce"},
                {"кетчуп", "кетчуп"}
        };
    }

    @Test
    public void getIngredientName() {
        Ingredient ingredient = new Ingredient(FILLING, nameIngredient, 0.5f);
        String actual = ingredient.getName();
        assertEquals("Данные не совпадают", expected, actual);
    }
}
