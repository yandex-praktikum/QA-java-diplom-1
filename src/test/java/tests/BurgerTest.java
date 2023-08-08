package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient filling;
    @Mock
    Ingredient sauce;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(filling);
        assertEquals(filling, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(sauce);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(sauce, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);
        Float actual = burger.getPrice();
        Float expected = 200f;
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.ingredients.add(sauce);
        burger.ingredients.add(filling);
        when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        when(bun.getPrice()).thenReturn(100F);
        when(sauce.getType()).thenReturn(SAUCE);
        when(sauce.getName()).thenReturn("Соус Spicy-X");
        when(sauce.getPrice()).thenReturn(100F);
        when(filling.getType()).thenReturn(FILLING);
        when(filling.getName()).thenReturn("Хрустящие минеральные кольца");
        when(filling.getPrice()).thenReturn(100F);
        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", sauce.getType().toString().toLowerCase(), sauce.getName()) +
                String.format("= %s %s =%n", filling.getType().toString().toLowerCase(), filling.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}