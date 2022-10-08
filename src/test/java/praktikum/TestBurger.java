package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.security.spec.ECField;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger;

    @Test
    public void testSetBuns() {
        burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredientNoIngredients() {
        burger = new Burger();
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testAddIngredientOneIngredient() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testAddIngredientSomeIngredients() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        assertEquals(5, burger.ingredients.size());
    }

    @Test(expected = Exception.class)
    public void testRemoveIngredientNoIngredientsShouldBeException() throws Exception {
        burger = new Burger();
        assertEquals(0, burger.ingredients.size());
        try {
            burger.removeIngredient(1);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Test(expected = Exception.class)
    public void testRemoveIngredientRemoveNonExistingIngredientShouldBeException() throws Exception {
        burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
        try {
            burger.removeIngredient(2);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Test
    public void testRemoveIngredientSomeIngredients() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        assertEquals(5, burger.ingredients.size());
        burger.removeIngredient(1);
        assertEquals(4, burger.ingredients.size());
    }

    @Test(expected = Exception.class)
    public void testMoveIngredientNoIngredientsShouldBeException() throws Exception {
        burger = new Burger();
        assertEquals(0, burger.ingredients.size());
        try {
            burger.moveIngredient(1, 2);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Test(expected = Exception.class)
    public void testMoveIngredientMoveFromNonExistingIngredientShouldBeException() throws Exception {
        burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
        try {
            burger.moveIngredient(2, 1);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Test(expected = Exception.class)
    public void testMoveIngredientMoveToNonExistingIngredientShouldBeException() throws Exception {
        burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
        try {
            burger.moveIngredient(1, 2);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Test
    public void testMoveIngredientSomeIngredients() {
        burger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "new name", 5f);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient, burger.ingredients.get(2));
        burger.moveIngredient(1, 2);
        assertEquals(ingredient1, burger.ingredients.get(2));
        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test(expected = Exception.class)
    public void testGetPriceNoBunAndNoIngredientsShouldBeException() throws Exception {
        burger = new Burger();
        try {
            burger.getPrice();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Test(expected = Exception.class)
    public void testGetPriceNoBunAndOneIngredientShouldBeException() throws Exception {
        burger = new Burger();
        burger.addIngredient(ingredient);
        try {
            burger.getPrice();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Test
    public void testGetPriceOneBunAndNoIngredients()  {
        burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(1f);
        burger.setBuns(bun);
        assertEquals(2, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetPriceZeroPrice() {
        burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(0f);
        Mockito.when(ingredient.getPrice()).thenReturn(0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(0, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetPriceNegativePrice() {
        burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(-1f);
        Mockito.when(ingredient.getPrice()).thenReturn(-1f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(-3, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetPriceOneBunAndTwoIngredients() {
        burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(1f);
        Mockito.when(ingredient.getPrice()).thenReturn(1f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        assertEquals(4, burger.getPrice(), 0.01);
    }

    /*
    getReceipt!!!!!
     */

}