package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerIngredientsTests {
    @Mock
    Ingredient filling;
    @Mock
    Ingredient sause;
    Burger burger;


    @Before

    public void fillBurger() {
        burger = new Burger();
        burger.ingredients.add(sause);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(filling);
        assertTrue("Ингредиент не добавился!", burger.ingredients.contains(filling));
    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(0);
        assertFalse("Ингредиент не удалился!", burger.ingredients.contains(sause));
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(filling);
        burger.moveIngredient(1, 0);
        assertEquals("Ингредиент не переместился!", filling, burger.ingredients.get(0));
    }
}
