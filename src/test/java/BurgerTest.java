import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    protected final static String BUN_NAME = "black bun";
    protected final static String SAUCE_NAME = "sour cream";
    protected final static String DINOSAUR_TOPPING = "dinosaur";
    protected final static String CUTLET_TOPPING = "cutlet";
    protected final static float BUN_PRICE = 100.0f;
    protected final static float SAUCE_PRICE = 200.0f;
    protected final static float DINOSAUR_PRICE = 200.0f;
    protected final static float CUTLET_PRICE = 100.0f;

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Mock
    private Ingredient ingredient3;

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
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.ingredients.add(ingredient1);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        when(bun.getPrice()).thenReturn(BUN_PRICE);
        when(ingredient1.getPrice()).thenReturn(DINOSAUR_PRICE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        assertThat("Incorrect price amount", burger.getPrice(), is(400.0f));

    }

    @Test
    public void testGetReceipt() {
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient1.getPrice()).thenReturn(CUTLET_PRICE);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getName()).thenReturn(CUTLET_TOPPING);
        Mockito.when(ingredient2.getPrice()).thenReturn(DINOSAUR_PRICE);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn(DINOSAUR_TOPPING);
        Mockito.when(ingredient3.getPrice()).thenReturn(SAUCE_PRICE);
        Mockito.when(ingredient3.getName()).thenReturn(SAUCE_NAME);
        Mockito.when(ingredient3.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient3);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= sauce sour cream =\r\n" +
                "= filling cutlet =\r\n" +
                "= filling dinosaur =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 700,000000\r\n";
        System.out.println(burger.getReceipt());
        assertThat("Information is incorrect!", burger.getReceipt().equals(expectedReceipt));
    }
}
