package praktikum;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest{
    private Burger burger = new Burger();
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;

    @BeforeEach
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(ingredient1));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
    }
    @Test
    public void getPrice() {
        float expectedPrice = 3.0f;
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        Mockito.when(bun.getPrice()).thenReturn(1f);
        Mockito.when(ingredient1.getPrice()).thenReturn(1f);
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }
    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        Bun brioche = new Bun("Brioche", 1.00f);
        burger.setBuns(brioche);
        Ingredient cheese = new Ingredient(IngredientType.FILLING, "Cheese", 0.50f);
        burger.addIngredient(cheese);

        //String expected ="(==== Brioche ====)\n= filling Cheese =\n(==== Brioche ====)\n\nPrice: 2,500000\n";
        String expected = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                "Brioche", "filling", "Cheese", "Brioche", 2.500000);
        assertEquals(expected, burger.getReceipt());
    }
}
