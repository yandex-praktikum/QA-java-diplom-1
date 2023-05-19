package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    List<Ingredient> ingredients;
    @Mock
    Ingredient ingredient;

    @Test
    public void setBuns() {
        Burger burger = new Burger(ingredients);
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger(ingredients);
        burger.addIngredient(ingredient);
        Mockito.verify(ingredients).add(ingredient);
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger(ingredients);
        burger.removeIngredient(2);
        Mockito.verify(ingredients).remove(2);
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger(ingredients);
        Mockito.when(ingredients.remove(2)).thenReturn(ingredient);
        burger.moveIngredient(2, 3);
        Mockito.verify(ingredients).remove(2);
        Mockito.verify(ingredients).add(3, ingredient);
    }

    @Test
    public void getPrice() {
        List<Ingredient> burgerIngredients = new ArrayList<>();
        burgerIngredients.add(ingredient);
        burgerIngredients.add(ingredient);
        Burger burger = new Burger(burgerIngredients);
        burger.bun = bun;
        Mockito.when(bun.getPrice()).thenReturn(3.45f);
        Mockito.when(ingredient.getPrice()).thenReturn(6.57f);
        assertEquals(20.04f, burger.getPrice(),0);
    }

    @Test
    public void getReceipt() {
        List<Ingredient> burgerIngredients = new ArrayList<>();
        burgerIngredients.add(ingredient);
        burgerIngredients.add(ingredient);
        Burger burger = new Burger(burgerIngredients);
        burger.bun = bun;
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(ingredient.getName()).thenReturn("ingredient");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(bun.getPrice()).thenReturn(3.45f);
        Mockito.when(ingredient.getPrice()).thenReturn(6.57f);
        StringBuilder expReceipt = new StringBuilder(String.format("(==== %s ====)%n", "white bun"));
        expReceipt.append(String.format("= %s %s =%n", "sauce", "ingredient"));
        expReceipt.append(String.format("= %s %s =%n", "sauce", "ingredient"));
        expReceipt.append(String.format("(==== %s ====)%n", "white bun"));
        expReceipt.append(String.format("%nPrice: %f%n", 20.04f));
        assertEquals(expReceipt.toString(), burger.getReceipt());
    }
}