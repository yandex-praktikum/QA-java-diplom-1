import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(burger.bun, bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient0 = new Ingredient(SAUCE, "Ингредиент1", 10f);
        Ingredient ingredient1 = new Ingredient(SAUCE, "Ингредиент2", 20f);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient0, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(20f);
        Mockito.when(ingredient.getPrice()).thenReturn(30f);
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        assertEquals(70f, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Соус Spicy-X");
        Mockito.when(bun.getPrice()).thenReturn(20f);
        Mockito.when(ingredient.getPrice()).thenReturn(30f);

        String expectedReceipt = "(==== Флюоресцентная булка ====)\n" +
                "= sauce Соус Spicy-X =\n" +
                "(==== Флюоресцентная булка ====)\n" +
                "\n" +
                "Price: 70,000000\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
