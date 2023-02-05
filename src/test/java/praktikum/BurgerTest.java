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
    //@Mock
    private Burger burger = new Burger();
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    List<Ingredient> ingredients = database.availableIngredients();
    List<Bun> buns = database.availableBuns();

    @Test
    public void setBunsTest() {
        Bun b = buns.get(0);
        burger.setBuns(b);
        assertEquals(b, burger.bun);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredients.get(0));
        burger.removeIngredient(0);
        assertTrue("ингридиент НЕ удален, НЕ пусто", burger.ingredients.isEmpty());
    }

    @Test
    public void addIngredientTest() {
        Ingredient i = ingredients.get(0);
        burger.addIngredient(i);
        assertEquals(i, burger.ingredients.get(burger.ingredients.size() - 1));
    }



    @Test
    public void moveIngredientTest() {
        burger.ingredients = ingredients;
        int index = burger.ingredients.size() - 1;
        int newIndex = burger.ingredients.size() - 2;
        Ingredient ingredientToMove = burger.ingredients.get(index);
        burger.moveIngredient(index, newIndex);
        Ingredient movedIngredient = burger.ingredients.get(newIndex);
        assertEquals(ingredientToMove, movedIngredient);
    }

    @Test
    public void getPriceOfBurgerTest() {
        Burger burger = new Burger();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        assertEquals(500.0, burger.getPrice(), 0);
    }
}