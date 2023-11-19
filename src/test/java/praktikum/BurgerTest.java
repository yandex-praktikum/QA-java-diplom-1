package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    private Burger burger;
    private IngredientType type;
    private final Ingredient newIngredient_1 = new Ingredient(type.FILLING,"Сосиска", (float) 57.00);
    private final Ingredient newIngredient_2 = new Ingredient(type.SAUCE,"Кетчуп", (float) 17.00);
    private final static String BUN_NAME = "Bread";

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
        Mockito.when(bun.getPrice()).thenReturn((float) 100.50);
        burger.setBuns(bun);
        float expectedPrice = (float) 275.00;
        assertEquals("Price of burger is not correct", expectedPrice, burger.getPrice(),0.0f);
    }

    @Test
    public void getReceiptTest() {
        burger.addIngredient(newIngredient_2);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        burger.setBuns(bun);

        String receipt = burger.getReceipt();
        float price = (float) burger.getPrice();
        String strPrice = Float.toString(price);
        String newStrPrice = strPrice.replace(".",",");

        assertTrue("Receipt of burger is not correct",
                receipt.contains(BUN_NAME)
                && receipt.contains(newIngredient_1.name)
                && receipt.contains(newIngredient_2.name)
                && receipt.contains(newStrPrice));
    }
}