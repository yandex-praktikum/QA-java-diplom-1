import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientOne;
    @Mock
    Ingredient ingredientTwo;
    @Mock
    Ingredient ingredientThree;
    @Mock
    Ingredient ingredientFour;

    Burger burger;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientThree);

        Mockito.when(bun.getPrice()).thenReturn(200f);
        Mockito.when(ingredientOne.getPrice()).thenReturn(100f);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(200f);
        Mockito.when(ingredientThree.getPrice()).thenReturn(300f);

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredientOne.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientTwo.getName()).thenReturn("cutlet");
        Mockito.when(ingredientThree.getName()).thenReturn("dinosaur");

        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientThree.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertNotNull(burger.bun);
    }
    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredientFour);
        assertEquals(4, burger.ingredients.size());
    }
    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(0);
        assertEquals(2, burger.ingredients.size());
    }
    @Test
    public void testMoveIngredients() {
        burger.moveIngredient(0, 2);
        assertEquals(2, burger.ingredients.indexOf(ingredientOne));
    }
    @Test
    public void testGetPrice() {
        float ingredientsSum = bun.getPrice() * 2 + ingredientOne.getPrice() + ingredientTwo.getPrice() + ingredientThree.getPrice();
        assertEquals(ingredientsSum, burger.getPrice(), Constants.Delta);
    }
    @Test
    public void testGetReceipt() {
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= sauce hot sauce =\r\n" +
                "= filling cutlet =\r\n" +
                "= filling dinosaur =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 1000,000000\r\n";
        burger.setBuns(bun);
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}