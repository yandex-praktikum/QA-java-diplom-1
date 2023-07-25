package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {



    IngredientType ingredientType;
    Ingredient ingredient;
    String name;
    float price;


    @Before
    public void setUp() {
        name = "ПЕСТО";
        ingredientType = IngredientType.SAUCE;
        price = 22.22f;
        ingredient = new Ingredient(ingredientType, name, price);
    }
    @Test
    public void checkGetPrice() {
        float expected = price;

        float actual = ingredient.getPrice();

        assertEquals(expected, actual, 0);
    }


    @Test
    public void checkGetName() {
        String expected = name;

        String actual = ingredient.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void checkGetType() {
        IngredientType expected = ingredientType;

        IngredientType actual = ingredient.getType();

        assertEquals(expected, actual);
    }
}