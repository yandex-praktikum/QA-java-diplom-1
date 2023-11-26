import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Database database;
    @Mock
    Bun bun;

    public BurgerTest() {
        database = new Database();
    }

    @Test
    public void addIngredientTest() {
        List<Ingredient> availableIngredients = database.availableIngredients();

        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(availableIngredients.get(1));

        Burger burger = new Burger();
        burger.addIngredient(availableIngredients.get(1));
        assertEquals(expectedIngredients, burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        List<Ingredient> availableIngredients = database.availableIngredients();

        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(availableIngredients.get(0));
        expectedIngredients.add(availableIngredients.get(2));

        Burger burger = new Burger();
        burger.addIngredient(availableIngredients.get(0));
        burger.addIngredient(availableIngredients.get(1));
        burger.addIngredient(availableIngredients.get(2));

        burger.removeIngredient(1);
        assertEquals(expectedIngredients, burger.ingredients);
    }

    @Test
    public void moveIngredientTest() {
        List<Ingredient> availableIngredients = database.availableIngredients();

        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(availableIngredients.get(1));
        expectedIngredients.add(availableIngredients.get(2));
        expectedIngredients.add(availableIngredients.get(0));
        expectedIngredients.add(availableIngredients.get(3));

        Burger burger = new Burger();
        burger.addIngredient(availableIngredients.get(0));
        burger.addIngredient(availableIngredients.get(1));
        burger.addIngredient(availableIngredients.get(2));
        burger.addIngredient(availableIngredients.get(3));

        burger.moveIngredient(0, 2);
        assertEquals(expectedIngredients, burger.ingredients);
    }

    @Test
    public void getPriceTest() {
        List<Ingredient> availableIngredients = database.availableIngredients();
        float expectedPrice = 900;

        Burger burger = new Burger();
        burger.addIngredient(availableIngredients.get(0));
        burger.addIngredient(availableIngredients.get(1));
        burger.addIngredient(availableIngredients.get(2));
        burger.addIngredient(availableIngredients.get(3));
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceiptTest(){
        List<Ingredient> availableIngredients = database.availableIngredients();
        String expectedReceipt = "(==== Alise ====)\r\n" +
                "= sauce hot sauce =\r\n" +
                "= sauce sour cream =\r\n" +
                "(==== Alise ====)\r\n" +
                "\r\nPrice: 300.000000\r\n";


        Burger burger = new Burger();
        burger.addIngredient(availableIngredients.get(0));
        burger.addIngredient(availableIngredients.get(1));

        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Alise");

        String actualReceipt = burger.getReceipt();
       assertEquals(expectedReceipt, actualReceipt);
    }
}
