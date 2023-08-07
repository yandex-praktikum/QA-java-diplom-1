package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void getPriceReturnPrice() {
        Ingredient ingredient=new Ingredient(IngredientType.FILLING, "test", 1);
        int actual = (int) ingredient.getPrice();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void getNameReturnName() {
        Ingredient ingredient=new Ingredient(IngredientType.FILLING, "test", 1);
        String actual = ingredient.getName();
        String expected = "test";
        assertEquals(expected, actual);
    }

    @Test
    public void getTypeReturnTypeOfIngredient() {
        Ingredient ingredient=new Ingredient(IngredientType.FILLING, "test", 1);
        String actual = ingredient.getType().name();
        String expected = "FILLING";
        assertEquals(expected, actual);
    }
}
