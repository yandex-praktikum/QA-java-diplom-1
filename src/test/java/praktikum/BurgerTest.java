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
    public void checkSetBuns() {
        when(bun.getName()).thenReturn("Железобетонная булочка");
        String actual = bun.getName();
        assertEquals("Железобетонная булочка", actual);
    }

    @Test
    public void checkAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void checkRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void checkMoveIngredient() {
        Burger burger = new Burger();
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);

        burger.addIngredient(ingredient);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);

        burger.addIngredient(ingredient);
        burger.moveIngredient(1, 0);
        assertEquals(IngredientType.SAUCE, burger.ingredients.get(0).getType());
    }

    @Test
    public void checkGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(393F);
        assertEquals(786F, burger.getPrice(), 0F);
    }

    @Test
    public void checkGetReceipt() {
        Burger burger = new Burger();
        when(bun.getName()).thenReturn("Лепёшка");
        when(bun.getPrice()).thenReturn(2.5F);
        burger.setBuns(bun);
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient.getName()).thenReturn("Жижа");
        when(ingredient.getPrice()).thenReturn(2F);
        burger.addIngredient(ingredient);
        assertEquals("(==== Лепёшка ====)\r\n"+ "= filling Жижа =\r\n" +"(==== Лепёшка ====)\r\n\r\n" +
                "Price: 7,000000\r\n", burger.getReceipt());
    }
}