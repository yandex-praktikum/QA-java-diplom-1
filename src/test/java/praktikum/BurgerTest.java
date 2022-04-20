package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();

        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();

        burger.addIngredient(ingredient);

        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();

        burger.addIngredient(ingredient);

        burger.removeIngredient(0);

        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        burger.moveIngredient(0, 1);

        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();

        when(bun.getPrice()).thenReturn(4.4f);
        when(ingredient.getPrice()).thenReturn(2.2f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float actual = burger.getPrice();

        assertEquals(0, Float.compare(11, actual));
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();

        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200);

        when(bun.getName()).thenReturn("white bun");

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String expected = "(==== white bun ====)\r\n" +
                "= filling dinosaur =\r\n" +
                "(==== white bun ====)\r\n" +
                "\r\n" +
                "Price: 200,000000\r\n";

        String actual = burger.getReceipt();

        assertEquals(expected, actual);
    }
}


