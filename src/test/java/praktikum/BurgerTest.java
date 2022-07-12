package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientFirst;
    @Mock
    Ingredient ingredientSecond;

    @Before
    public void initObject() {
        burger = new Burger();
    }

    @Test
    public void shouldSetBunForBurger() {
        burger.setBuns(bun);
        assertEquals("Set bun for burger error", bun, burger.bun);
    }

    @Test
    public void shouldAddIngredientToBurger() {
        burger.addIngredient(ingredientFirst);
        assertTrue("Add ingredient for burger error", burger.ingredients.contains(ingredientFirst));
    }

    @Test
    public void shouldRemoveIngredientFromBurger() {
        burger.addIngredient(ingredientFirst);
        burger.removeIngredient(0);
        assertTrue("Remove ingredient from burger error", burger.ingredients.isEmpty());
    }

    @Test
    public void shouldMoveIngredientsInBurger() {
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(0, 1);
        assertEquals("Move ingredients error", ingredientSecond, burger.ingredients.get(0));
    }

    @Test
    public void shouldGetBurgerPrice() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredientFirst);
        Mockito.when(bun.getPrice()).thenReturn(200f);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(100f);
        float actual = burger.getPrice();
        float expected = 500f;
        assertEquals("Get price for burger error", expected, actual, 0.0);
    }

    @Test
    public void shouldGetBurgerReceipt() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);

        burger.ingredients.add(ingredientFirst);
        Mockito.when(ingredientFirst.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientFirst.getName()).thenReturn("sour cream");
        Mockito.when(ingredientFirst.getPrice()).thenReturn(200f);

        burger.ingredients.add(ingredientSecond);
        Mockito.when(ingredientSecond.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientSecond.getName()).thenReturn("sausage");
        Mockito.when(ingredientSecond.getPrice()).thenReturn(300f);

        Mockito.when(burger.getPrice()).thenReturn(700f);

        String actual = burger.getReceipt();
        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredientFirst.getType().toString().toLowerCase(),
                        ingredientFirst.getName()) +
                String.format("= %s %s =%n", ingredientSecond.getType().toString().toLowerCase(),
                        ingredientSecond.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals("Get burger receipt error", expected, actual);
    }
}
