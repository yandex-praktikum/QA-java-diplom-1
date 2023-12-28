package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientSauce;
    @Mock
    Ingredient ingredientFilling;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        int expected = 1;
        burger.addIngredient(ingredientSauce);
        assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        int expected = 0;
        burger.addIngredient(ingredientSauce);
        burger.removeIngredient(0);
        assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.ingredients.addAll(Arrays.asList(ingredientSauce, ingredientFilling));
        List<Ingredient> expectedIngredientsOrder = new ArrayList<>(Arrays.asList(ingredientFilling, ingredientSauce));
        burger.moveIngredient(0, 1);
        burger.removeIngredient(0);
        expectedIngredientsOrder.remove(0);
        assertEquals(expectedIngredientsOrder, burger.ingredients);
    }

    @Test
    public void testGetPriceBurger() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        when(bun.getPrice()).thenReturn(100F);
        when(ingredientSauce.getPrice()).thenReturn(200F);
        when(ingredientFilling.getPrice()).thenReturn(300F);
        int expectedPrice = (100 * 2) + 200 + 300;
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);

        burger.ingredients.add(ingredientFilling);
        burger.ingredients.add(ingredientSauce);

        Mockito.when(bun.getName()).thenReturn("red bun");


        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientFilling.getName()).thenReturn("dinosaur");
        Mockito.when(ingredientFilling.getPrice()).thenReturn(200F);

        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSauce.getName()).thenReturn("chili sauce");
        Mockito.when(ingredientSauce.getPrice()).thenReturn(300F);

        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredientFilling.getType().toString().toLowerCase(), ingredientFilling.getName()) +
                String.format("= %s %s =%n", ingredientSauce.getType().toString().toLowerCase(), ingredientSauce.getName()) +
                String.format("(==== %s ====)%n%nPrice: %f%n", bun.getName(), burger.getPrice());

        assertEquals(expected, burger.getReceipt());
    }

}