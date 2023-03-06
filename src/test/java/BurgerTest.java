import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        ingredient = Mockito.mock(Ingredient.class);
        burger.ingredients = List.of(ingredient);
        assertEquals(List.of(ingredient),burger.ingredients);
    }

    @Test
    public void testRemoveIngredient() {
        int index =0;
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "Майонез", 35);
        burger.ingredients.add(ingredient);
        burger.removeIngredient(index);
        assertEquals(0,burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        int index =0;
        int newIndex = 0;
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "Майонез", 35);
        burger.ingredients.add(ingredient);
        burger.moveIngredient(index, newIndex);
        assertEquals(ingredient,burger.ingredients.get(newIndex));
    }

    @Test
    public void testGetPriceReturn13() {
        Burger burger = new Burger();
        bun = Mockito.mock(Bun.class);
        ingredient = Mockito.mock(Ingredient.class);
        burger.ingredients = List.of(ingredient);
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(5.0F);
        when(ingredient.getPrice()).thenReturn(3.0F);
        assertEquals(13.0F,burger.getPrice(),0);
    }

    @Test
    public void testGetReceiptReturnReceipt() {
        Burger burger = new Burger();
        bun = Mockito.mock(Bun.class);
        ingredient = Mockito.mock(Ingredient.class);
        burger.ingredients = List.of(ingredient);
        burger.setBuns(bun);
        when(burger.getPrice()).thenReturn(10.0F);
        when(bun.getName()).thenReturn("Булка");
        when(ingredient.getName()).thenReturn("Начинка");
        when(ingredient.getType()).thenReturn(FILLING);
        StringBuilder expected = new StringBuilder(String.format("(==== Булка ====)%n= filling Начинка =%n(==== Булка ====)%n%nPrice: 10,000000%n"));
        assertEquals(expected.toString(),burger.getReceipt());
    }
}