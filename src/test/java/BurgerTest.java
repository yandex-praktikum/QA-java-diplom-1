import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BurgerTest {

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mockBun.getName()).thenReturn("testBun");
        when(mockBun.getPrice()).thenReturn(50f);

        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient1.getName()).thenReturn("testFilling1");
        when(mockIngredient1.getPrice()).thenReturn(30f);

        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient2.getName()).thenReturn("testSauce2");
        when(mockIngredient2.getPrice()).thenReturn(20f);
    }

    @Test
    public void testGetPriceWithIngredients() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        when(mockIngredient1.getPrice()).thenReturn(30f);
        when(mockIngredient2.getPrice()).thenReturn(40f);

        assertEquals(170f, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetPriceWithoutIngredients() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);

        assertEquals(100f, burger.getPrice(), 0.001);
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient1);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(1, ingredients.size());
        assertEquals(mockIngredient1, ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.removeIngredient(1);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(1, ingredients.size());
        assertEquals(mockIngredient1, ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.moveIngredient(1, 0);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(mockIngredient2, ingredients.get(0));
        assertEquals(mockIngredient1, ingredients.get(1));
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        String price = String.format("%f%n", 150f);

        String expectedReceipt = "(==== testBun ====)\n" +
                "= filling testFilling1 =\n" +
                "= sauce testSauce2 =\n" +
                "(==== testBun ====)\n" +
                "\nPrice: " + price;

        assertEquals(expectedReceipt, burger.getReceipt());
    }

}
