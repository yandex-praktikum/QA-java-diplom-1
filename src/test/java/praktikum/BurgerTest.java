package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;
    @Mock
    Bun bun;

    Burger burger = new Burger();

    @Test
    public void setBuns() {
        assertNull(burger.bun);
        burger.setBuns(bun);
        assertNotNull(burger.bun);
    }

    @Test
    public void addIngredient() {
        int firstSize = burger.ingredients.size();
        burger.addIngredient(ingredient);
        int newSize = burger.ingredients.size();
        assertTrue((newSize - firstSize) == 1);
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        int firstSize = burger.ingredients.size();
        burger.removeIngredient(burger.ingredients.size() - 1);
        int newSize = burger.ingredients.size();
        assertTrue((firstSize - newSize) == 1);
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredient);
        Ingredient ingredientNumberOne = burger.ingredients.get(burger.ingredients.size() - 1);
        burger.addIngredient(ingredient1);
        Ingredient ingredientNumberOTwo = burger.ingredients.get(burger.ingredients.size() - 1);
        burger.moveIngredient(burger.ingredients.size() - 2, burger.ingredients.size() - 1);
        assertTrue(ingredientNumberOne != ingredientNumberOTwo);
        assertEquals(ingredientNumberOne, burger.ingredients.get(burger.ingredients.size() - 1));
    }

}