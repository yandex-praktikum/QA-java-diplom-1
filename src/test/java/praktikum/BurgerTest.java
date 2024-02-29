package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    private Burger burger;
    private final Ingredient newIngredient_1 = Mockito.mock(Ingredient.class);
    private final Ingredient newIngredient_2 = Mockito.mock(Ingredient.class);
    private final static String BUN_NAME = "Bread";
    private final static String INGREDIENT1_NAME = "Sausage";
    private final static String INGREDIENT2_NAME = "Ketchup";
    private final static double DELTA = 0.0f;

    @Before
    public void beforeBurgerTest() {
        burger = new Burger();
        burger.addIngredient(newIngredient_1);
    }

    @Test
    public void addIngredientTest() {
        List<Ingredient> listExpected = new ArrayList<>();
        listExpected.add(newIngredient_1);
        assertEquals("List of ingredients is not correct", listExpected, burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(newIngredient_2);
        burger.removeIngredient(0);
        List<Ingredient> listExpected = new ArrayList<>();
        listExpected.add(newIngredient_2);
        assertEquals("List of ingredients is not correct", listExpected, burger.ingredients);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(newIngredient_2);
        burger.moveIngredient(1,0);
        List<Ingredient> listExpected = new ArrayList<>();
        listExpected.add(newIngredient_2);
        listExpected.add(newIngredient_1);
        assertEquals("List of ingredients is not correct", listExpected, burger.ingredients);
    }

    @Test
    public void getPriceTest() {
        burger.addIngredient(newIngredient_2);
        Mockito.when(bun.getPrice()).thenReturn((float) 50);
        burger.setBuns(bun);
        float expectedPrice = (float) 100;
        assertEquals("Price of burger is not correct", expectedPrice, burger.getPrice(), DELTA);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(newIngredient_1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(newIngredient_2.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(newIngredient_1.getName()).thenReturn(INGREDIENT1_NAME);
        Mockito.when(newIngredient_2.getName()).thenReturn(INGREDIENT2_NAME);
        Mockito.when(newIngredient_1.getPrice()).thenReturn((float) 100);
        Mockito.when(newIngredient_2.getPrice()).thenReturn((float) 50);

        burger.addIngredient(newIngredient_2);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        burger.setBuns(bun);

        String receipt = burger.getReceipt();
        float price = burger.getPrice();
        String strPrice = Float.toString(price);
        String newStrPrice = strPrice.replace(".",",");

        assertTrue("Receipt of burger is not correct",
                receipt.contains(BUN_NAME)
                && receipt.contains(INGREDIENT1_NAME)
                && receipt.contains(INGREDIENT2_NAME)
                && receipt.contains(newStrPrice));
    }
}