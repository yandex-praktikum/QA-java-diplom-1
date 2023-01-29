package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Database database = new Database();
    @Mock
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    List<Ingredient> ingredients = database.availableIngredients();
    List<Bun> buns = database.availableBuns();

    @Test
    public void setBunsTest() {
        burger.bun = bun;
        burger.setBuns(buns.get(1));
        Mockito.verify(burger, Mockito.times(1)).setBuns(buns.get(1));
        assertNotNull(burger.bun);

    }
    @Test
    public void removeIngredientTest() {
        burger.ingredients = ingredients;
        burger.addIngredient(ingredients.get(0));
        burger.removeIngredient(0);
        Mockito.verify(burger, Mockito.times(1)).removeIngredient(0);
        System.out.println(ingredients.isEmpty());
        assertTrue(ingredients.isEmpty());
        //assertTrue("ингридиент удален, пусто", ingredients.isEmpty());
        //System.out.println(ingredients.isEmpty());
        //assertFalse("Not Empty", ingredients.isEmpty());
    }
    @Test
    public void addIngredientTest() {
        burger.ingredients = ingredients;
        burger.addIngredient(ingredients.get(1));
        assertNotNull(burger.ingredients);
        Mockito.verify(burger, Mockito.times(1)).addIngredient(ingredients.get(1));
    }
    @Test
    public void moveIngredientTest() {
        burger.ingredients = ingredients;
        burger.addIngredient(ingredient);
        burger.moveIngredient(0,1);
        Mockito.verify(burger, Mockito.times(1)).moveIngredient(0,1);
        assertFalse(ingredients.isEmpty());
    }
    @Test
    public void getPriceOfBurgerTest() {

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(400F);
        assertEquals("Метод должен возвращать цену 1000",1000, burger.getPrice(), 0);

    }
}