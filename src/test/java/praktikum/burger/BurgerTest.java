package praktikum.burger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        assertTrue(burger.ingredients.contains(firstIngredient));
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.ingredients.add(firstIngredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals(burger.ingredients.get(0), secondIngredient);
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(50f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(20f);
        burger.setBuns(bun);
        burger.ingredients.add(firstIngredient);
        float actual = burger.getPrice();
        assertEquals(actual, 120f, 0);
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Булочка");
        Mockito.when(bun.getPrice()).thenReturn(50f);
        Mockito.when(firstIngredient.getName()).thenReturn("Сыр");
        Mockito.when(firstIngredient.getPrice()).thenReturn(25f);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn("Кетчуп");
        Mockito.when(secondIngredient.getPrice()).thenReturn(15f);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bun);
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        String actual = burger.getReceipt();
        String expected =
                "(==== Булочка ====)\r\n" +
                        "= filling Сыр =\r\n" +
                        "= sauce Кетчуп =\r\n" +
                        "(==== Булочка ====)\r\n" +
                        "\r\n" +
                        "Price: 140,000000\r\n";
        assertEquals(expected, actual);
    }
}