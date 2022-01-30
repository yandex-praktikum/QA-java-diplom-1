package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientBurgerTest() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientBurgerTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientBurgerTest() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Краторная булка N-200i", 1000));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90));
        burger.moveIngredient(0, 1);
        assertEquals("Краторная булка N-200i", burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceBurgerTest() {
        float price = 100;
        float expectedPrice = price * 2 + price;
        when(bun.getPrice()).thenReturn(price);
        when(ingredient.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertTrue(expectedPrice == burger.getPrice());
    }

    @Test
    public void getReceiptBurgerTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(300f);
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient.getName()).thenReturn("dinosaur");
        when(ingredient.getPrice()).thenReturn(300f);
        String expected = "(==== black bun ====)" + "\n" + "= filling dinosaur =" + "\n" + "(==== black bun ====)" + "\n\n" + "Price: 900.000000" + "\n";
        Assert.assertEquals(expected, burger.getReceipt());
    }
}
