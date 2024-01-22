package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.*;

import static praktikum.IngredientType.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    private Burger burger = new Burger();

    @Mock
    private Ingredient firstFillingIngredient;
    @Mock
    private Ingredient secondSauceIngredient;

    @Before
    public void setUp() {
        Mockito.when(bun.getName()).thenReturn("FirstBun");
        Mockito.when(bun.getPrice()).thenReturn(100f);

        Mockito.when(firstFillingIngredient.getType()).thenReturn(FILLING);
        Mockito.when(firstFillingIngredient.getName()).thenReturn("firstFilling");
        Mockito.when(firstFillingIngredient.getPrice()).thenReturn(100.50f);

        Mockito.when(secondSauceIngredient.getType()).thenReturn(SAUCE);
        Mockito.when(secondSauceIngredient.getName()).thenReturn("firstSauce");
        Mockito.when(secondSauceIngredient.getPrice()).thenReturn(200f);

        burger.setBuns(bun);
        burger.addIngredient(firstFillingIngredient);
        burger.addIngredient(secondSauceIngredient);

    }

    @Test
    public void setBunsTest() {
        assertEquals(bun, burger.bun);
    }


    @Test
    public void addIngredientTest() {
        assertEquals(burger.ingredients.size(), 2);
    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.size(), 1);

        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }


    @Test
    public void moveIngredientTest() {
        burger.moveIngredient(0, 1);
        assertEquals(secondSauceIngredient, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        float actualPrice = burger.getPrice();
        float expectedPrice = (bun.getPrice() * 2) + firstFillingIngredient.getPrice() + secondSauceIngredient.getPrice();
        assertEquals(expectedPrice, actualPrice, 0f);
    }


    @Test
    public void getReceiptTest() {

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", "FirstBun"));
        expectedReceipt.append(String.format("= %s %s =%n", "filling", "firstFilling"));
        expectedReceipt.append(String.format("= %s %s =%n", "sauce", "firstSauce"));
        expectedReceipt.append(String.format("(==== %s ====)%n", "FirstBun"));
        expectedReceipt.append(String.format("%nPrice: %f%n", 500.500000f));

//        String expectedReceipt = "(==== FirstBun ====)\n" +
//                "= filling firstFilling =\n" +
//                "= sauce firstSauce =\n" +
//                "(==== FirstBun ====)\n" +
//
//                "\nPrice: 500,500000\n";

        assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }
}
