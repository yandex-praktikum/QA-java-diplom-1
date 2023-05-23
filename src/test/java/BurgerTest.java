import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test

    public void ingredientShouldBeAdded() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.size() != 0);
    }

    @Test
    public void ingredientShouldBeRemoved() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 300));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void ingredientShouldBeMoved() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        String ingredientsBefore = burger.ingredients.toString();
        burger.moveIngredient(0, 1);
        String ingredientsAfter = burger.ingredients.toString();
        assertNotEquals(ingredientsAfter, ingredientsBefore);
    }

    @Test
    public void getValidPrice() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(200F);
        burger.setBuns(bun);
        float expected = 400F;
        assertEquals("Error", burger.getPrice(), expected, 0);
    }

    @Test
    public void getValidReceipt() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        Bun bun = new Bun("Булка", 150);
        burger.setBuns(bun);
        String expectedReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, burger.getReceipt());
        System.out.println(burger.getReceipt());
    }
}