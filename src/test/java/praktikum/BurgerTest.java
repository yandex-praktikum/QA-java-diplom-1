package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {

    Burger burger = new Burger();

    private final float bunPrice = 2f;
    private final float ingredientPrice = 1f;
    private final String bunName = "булка";
    private final String ingredientName = "соус";

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient secondIngredient;

    @Before
    public void init() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSetBuns() {

        burger.setBuns(bun);
        assertEquals(bun,
                burger.bun);
    }

    @Test
    public void testAddIngredient() {

        burger.addIngredient(ingredient);
        assertEquals(ingredient,
                burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {

        burger.addIngredient(ingredient);
        assertEquals(burger.ingredients.get(0), ingredient);
        burger.removeIngredient(0);
        assertEquals(0,
                burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {

        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        assertEquals(burger.ingredients.get(0), ingredient);
        burger.moveIngredient(1,0);
        assertEquals(secondIngredient,
                burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        burger.addIngredient(ingredient);
        assertEquals( 5,
                burger.getPrice(),
                0.1);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        String receipt = burger.getReceipt();
        assertEquals(
                "(==== булка ====)\r\n" +
                        "= sauce соус =\r\n" +
                        "(==== булка ====)\r\n" +
                        "\r\n" +
                        "Price: 5,000000\r\n",
                receipt);
    }
}