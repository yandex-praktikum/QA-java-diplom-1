package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setUp(){
        ingredient = new Ingredient(IngredientType.SAUCE, "TestBurger", 999);
    }

    @Test
    public void getPrice() {
        float expected = 999;
        float actual = ingredient.getPrice();

        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void getName() {
        String expected = "TestBurger";
        String actual = ingredient.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void getType() {
        String expected = "SAUCE";
        String actual = ingredient.getType().toString();

        assertEquals(expected, actual);
    }
}